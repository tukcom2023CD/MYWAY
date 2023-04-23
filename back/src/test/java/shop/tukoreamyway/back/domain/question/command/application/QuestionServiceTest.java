package shop.tukoreamyway.back.domain.question.command.application;

import static org.assertj.core.api.Assertions.assertThat;

import static shop.tukoreamyway.back.support.database.SampleDataLongTypeId.TEAM1;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
import shop.tukoreamyway.back.domain.question.dto.UpdateQuestionRequest;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryRepository;
import shop.tukoreamyway.back.domain.staff.command.application.StaffRepository;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryRepository;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.domain.team.query.application.TeamQueryRepository;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;
import shop.tukoreamyway.back.support.database.UseSampleData;

import java.util.List;

@Slf4j
@EnableDataBaseTest
@DisplayName("QuestionService에서")
class QuestionServiceTest extends LoginTest {
    @Autowired private QuestionService questionService;
    @Autowired private QuestionQueryRepository questionQueryRepository;
    @Autowired private StaffRepository staffRepository;
    @Autowired private StaffQueryRepository staffQueryRepository;
    @Autowired private StaffQueryService staffQueryService;
    @Autowired private TeamQueryRepository teamRepository;

    @Nested
    @DisplayName("create 호출 시")
    class CallCreate {
        @Test
        @DisplayName("저장을 수행하는가")
        @UseSampleData
        void successSave() {
            // given
            List<String> tags = List.of("커뮤니케이션", "개발");
            Team team = teamRepository.findById(TEAM1.getId()).orElseThrow();
            Staff staff = staffRepository.save(new Staff(team, loginUser));
            QuestionRequest questionRequest = new QuestionRequest("제목", "내용", TEAM1.getId(), tags);
            // when
            IdResponse<Long> longIdResponse = questionService.create(questionRequest);

            // then
            assertThat(longIdResponse).isNotNull();
            Question question = questionQueryRepository.findById(longIdResponse.getId()).get();
            question.getTags().forEach(i -> log.info("{}", i.getTag().getName()));
            assertThat(question.getTags()).isNotEmpty();
            assertThat(question.getTeamId()).isEqualTo(TEAM1.getId());
            assertThat(question.getTitle()).isEqualTo(questionRequest.getTitle());
            assertThat(question.getWriter()).isEqualTo(staff);
            assertThat(question.getContent()).isEqualTo(questionRequest.getContent());
        }
    }

    @Nested
    @DisplayName("update 호출 시")
    class CallUpdate {
        @Test
        @DisplayName("수정을 수행하는가")
        @UseSampleData
        void successUpdate() {
            // given
            List<String> tags = List.of("커뮤니케이션", "개발");
            Team team = teamRepository.findById(TEAM1.getId()).orElseThrow();
            Staff staff = staffRepository.save(new Staff(team, loginUser));
            QuestionRequest questionRequest = new QuestionRequest("제목", "내용", TEAM1.getId(), tags);
            // when
            IdResponse<Long> longIdResponse = questionService.create(questionRequest);

            UpdateQuestionRequest updateQuestionRequest = new UpdateQuestionRequest("변경된 내용");
            questionService.update(longIdResponse.getId(), updateQuestionRequest);

            // then
            assertThat(longIdResponse).isNotNull();
            Question question = questionQueryRepository.findById(longIdResponse.getId()).get();
            assertThat(question.getContent()).isEqualTo(updateQuestionRequest.getContent());
        }
    }

    @Nested
    @DisplayName("delete 호출 시")
    class CallDelete {
        @Test
        @DisplayName("삭제를 수행하는가")
        @UseSampleData
        void successDelete() {
            // given
            List<String> tags = List.of("커뮤니케이션", "개발");
            Team team = teamRepository.findById(TEAM1.getId()).orElseThrow();
            Staff staff = staffRepository.save(new Staff(team, loginUser));
            QuestionRequest questionRequest = new QuestionRequest("제목", "내용", TEAM1.getId(), tags);
            // when
            IdResponse<Long> longIdResponse = questionService.create(questionRequest);

            questionService.deleteById(longIdResponse.getId());

            // then
            assertThat(questionQueryRepository.findById(longIdResponse.getId())).isEmpty();
        }
    }
}
