package shop.tukoreamyway.back.domain.question.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.ability.command.application.AbilityService;
import shop.tukoreamyway.back.domain.ability.dto.AbilityRequest;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.ability.entity.GrantLocation;
import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
import shop.tukoreamyway.back.domain.question.dto.UpdateQuestionRequest;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.question.mapper.QuestionMapper;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryRepository;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffLoader;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.global.service.CommandService;
import shop.tukoreamyway.back.global.service.EntityLoader;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

@CommandService
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final EntityLoader<Team, Long> teamLoader;
    private final StaffLoader staffLoader;
    private final QuestionQueryRepository questionQueryRepository;
    private final QuestionMapper questionMapper;
    private final AbilityService abilityService;
    private final QuestionTagGenerator questionTagGenerator;

    public IdResponse<Long> create(final QuestionRequest dto) {
        final Team team = teamLoader.getEntity(dto.getTeamId());
        final Staff writer = staffLoader.getActiveStaff(dto.getTeamId());
        final Question question =
                questionRepository.save(questionMapper.toEntity(dto, team, writer));
        abilityService.create(
                new AbilityRequest(
                        AbilityCategory.COMMUNICATION,
                        writer.getId(),
                        10L,
                        LocalDateTime.now(),
                        GrantLocation.WRITE_QUESTION,
                        null));
        questionTagGenerator.generate(question, dto.getTags());
        return new IdResponse<>(question.getId());
    }

    public void update(final Long id, final UpdateQuestionRequest dto) {
        getEntity(id).update(dto.getContent());
    }

    public void deleteById(final Long id) {
        questionRepository.deleteById(id);
    }

    private Question getEntity(final Long id) {
        return questionQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
