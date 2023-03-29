package shop.tukoreamyway.back.domain.question.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
import shop.tukoreamyway.back.domain.question.dto.QuestionResponse;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.team.entity.Team;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionMapper {
    @Mapping(target = "tags")
    Question toEntity(QuestionRequest dto, Team team, Staff writer);

    @Mapping(target = "tags", ignore = true)
    QuestionResponse toResponse(Question entity);
}
