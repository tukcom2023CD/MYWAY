package shop.tukoreamyway.back.domain.answer.command.application;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.tukoreamyway.back.domain.answer.dto.AnswerRequest;
import shop.tukoreamyway.back.domain.answer.dto.UpdateAnswerRequest;
import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answer.query.application.AnswerQueryRepository;
import shop.tukoreamyway.back.domain.question.command.application.QuestionService;
import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
import shop.tukoreamyway.back.domain.question.dto.UpdateQuestionRequest;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryRepository;
import shop.tukoreamyway.back.domain.staff.command.application.StaffRepository;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.domain.team.query.application.TeamQueryRepository;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;
import shop.tukoreamyway.back.support.database.UseSampleData;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static shop.tukoreamyway.back.support.database.SampleDataLongTypeId.TEAM1;

@EnableDataBaseTest
@DisplayName("AnswerService에서")
public class AnswerServiceTest extends LoginTest {

    @Autowired private QuestionService questionService;
    @Autowired private AnswerService answerService;
    @Autowired private AnswerQueryRepository answerQueryRepository;
    @Autowired private StaffRepository staffRepository;
    @Autowired private TeamQueryRepository teamRepository;
    @Autowired private QuestionQueryRepository questionQueryRepository;


    @Nested
    @DisplayName("create 호출 시")
    class CallCreate {
        @Test
        @DisplayName("저장을 수행하는가")
        @UseSampleData
        void successSave() throws Exception {
            // given
            List<String> tags = List.of("커뮤니케이션", "개발");
            Team team = teamRepository.findById(TEAM1.getId()).orElseThrow();
            staffRepository.save(new Staff(team, loginUser));
            QuestionRequest questionRequest = new QuestionRequest("제목", "내용", TEAM1.getId(), tags);
            IdResponse<Long> QuestionLongIdResponse = questionService.create(questionRequest);
            Question question = questionQueryRepository.findById(QuestionLongIdResponse.getId()).get();

            AnswerRequest answerRequest = new AnswerRequest("내용", question.getId());
            // when
            IdResponse<Long> answerLongIdResponse = answerService.create(answerRequest);

            // then
            assertThat(answerLongIdResponse).isNotNull();
            Answer answer = answerQueryRepository.findById(answerLongIdResponse.getId()).get();
            assertThat(answer.getContent()).isEqualTo(answerRequest.getContent());
            assertThat(answer.getQuestion()).isEqualTo(question);
        }
    }

    @Nested
    @DisplayName("update 호출 시")
    class CallUpdate {
        @Test
        @DisplayName("수정을 수행하는가")
        @UseSampleData
        void successUpdate() throws Exception {
            // given
            List<String> tags = List.of("커뮤니케이션", "개발");
            Team team = teamRepository.findById(TEAM1.getId()).orElseThrow();
            staffRepository.save(new Staff(team, loginUser));
            QuestionRequest questionRequest = new QuestionRequest("제목", "내용", TEAM1.getId(), tags);
            IdResponse<Long> questionLongIdResponse = questionService.create(questionRequest);
            Question question = questionQueryRepository.findById(questionLongIdResponse.getId()).get();

            AnswerRequest answerRequest = new AnswerRequest("내용", question.getId());
            // when
            IdResponse<Long> answerLongIdResponse = answerService.create(answerRequest);
            UpdateAnswerRequest updateAnswerRequest = new UpdateAnswerRequest("변경된 내용");
            answerService.update(answerLongIdResponse.getId(), updateAnswerRequest);

            // then
            assertThat(answerLongIdResponse).isNotNull();
            Answer answer = answerQueryRepository.findById(answerLongIdResponse.getId()).get();
            assertThat(answer.getContent()).isEqualTo(updateAnswerRequest.getContent());
        }
    }

    @Nested
    @DisplayName("delete 호출 시")
    class CallDelete {
        @Test
        @DisplayName("삭제를 수행하는가")
        @UseSampleData
        void successDelete() throws Exception {
            // given
            List<String> tags = List.of("커뮤니케이션", "개발");
            Team team = teamRepository.findById(TEAM1.getId()).orElseThrow();
            staffRepository.save(new Staff(team, loginUser));
            QuestionRequest questionRequest = new QuestionRequest("제목", "내용", TEAM1.getId(), tags);
            IdResponse<Long> questionLongIdResponse = questionService.create(questionRequest);
            Question question = questionQueryRepository.findById(questionLongIdResponse.getId()).get();

            AnswerRequest answerRequest = new AnswerRequest("내용", question.getId());
            // when
            IdResponse<Long> answerLongIdResponse = answerService.create(answerRequest);
            answerService.deleteById(answerLongIdResponse.getId());

            // then
            assertThat(answerQueryRepository.findById(answerLongIdResponse.getId())).isEmpty();
        }
    }
}
