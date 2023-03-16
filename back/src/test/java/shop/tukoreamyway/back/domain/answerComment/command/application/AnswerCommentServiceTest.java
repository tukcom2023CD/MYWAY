package shop.tukoreamyway.back.domain.answerComment.command.application;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import shop.tukoreamyway.back.domain.answer.command.application.AnswerService;
import shop.tukoreamyway.back.domain.answer.dto.AnswerRequest;
import shop.tukoreamyway.back.domain.answer.entity.Answer;
import shop.tukoreamyway.back.domain.answer.query.application.AnswerQueryRepository;
import shop.tukoreamyway.back.domain.answercomment.command.application.AnswerCommentService;
import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentRequest;
import shop.tukoreamyway.back.domain.answercomment.dto.UpdateAnswerCommentRequest;
import shop.tukoreamyway.back.domain.answercomment.entity.AnswerComment;
import shop.tukoreamyway.back.domain.answercomment.query.application.AnswerCommentQueryRepository;
import shop.tukoreamyway.back.domain.question.command.application.QuestionService;
import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
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
@Slf4j
@DisplayName("AnswerCommentService에서")
public class AnswerCommentServiceTest extends LoginTest {

    @Autowired private AnswerCommentService answerCommentService;
    @Autowired private AnswerCommentQueryRepository answerCommentQueryRepository;
    @Autowired private StaffRepository staffRepository;
    @Autowired private TeamQueryRepository teamRepository;
    @Autowired private QuestionService questionService;
    @Autowired private QuestionQueryRepository questionQueryRepository;
    @Autowired private AnswerQueryRepository answerQueryRepository;
    @Autowired private AnswerService answerService;

    @Nested
    @DisplayName("answerComment-create 호출 시")
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
            IdResponse<Long> questionLongIdResponse = questionService.create(questionRequest);
            Question question =
                    questionQueryRepository.findById(questionLongIdResponse.getId()).get();

            AnswerRequest answerRequest = new AnswerRequest("내용", question.getId());
            IdResponse<Long> answerLongIdResponse = answerService.create(answerRequest);
            Answer answer = answerQueryRepository.findById(answerLongIdResponse.getId()).get();

            // when
            AnswerCommentRequest answerCommentRequest =
                    new AnswerCommentRequest("내용", answer.getId());
            IdResponse<Long> answerCommentLongIdResponse =
                    answerCommentService.create(answerCommentRequest);

            // then
            assertThat(answerCommentLongIdResponse).isNotNull();
            AnswerComment answerComment =
                    answerCommentQueryRepository
                            .findById(answerCommentLongIdResponse.getId())
                            .get();
            assertThat(answerComment.getContent()).isEqualTo(answerCommentRequest.getContent());

            // 아래 부분에서 오류 발생
            assertThat(answerComment.getAnswer()).isEqualTo(answer);
        }
    }

    @Nested
    @DisplayName("answerComment-update 호출 시")
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
            Question question =
                    questionQueryRepository.findById(questionLongIdResponse.getId()).get();

            AnswerRequest answerRequest = new AnswerRequest("내용", question.getId());
            IdResponse<Long> answerLongIdResponse = answerService.create(answerRequest);
            Answer answer = answerQueryRepository.findById(answerLongIdResponse.getId()).get();

            AnswerCommentRequest answerCommentRequest =
                    new AnswerCommentRequest("내용", answer.getId());
            IdResponse<Long> answerCommentLongIdResponse =
                    answerCommentService.create(answerCommentRequest);

            // when
            UpdateAnswerCommentRequest updateAnswerCommentRequest =
                    new UpdateAnswerCommentRequest("변경된 내용");
            answerCommentService.update(
                    answerCommentLongIdResponse.getId(), updateAnswerCommentRequest);
            AnswerComment answerComment =
                    answerCommentQueryRepository
                            .findById(answerCommentLongIdResponse.getId())
                            .get();

            // then
            assertThat(answerCommentLongIdResponse).isNotNull();
            assertThat(answerComment.getContent())
                    .isEqualTo(updateAnswerCommentRequest.getContent());
        }
    }

    @Nested
    @DisplayName("answerComment-delete 호출 시")
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
            Question question =
                    questionQueryRepository.findById(questionLongIdResponse.getId()).get();

            AnswerRequest answerRequest = new AnswerRequest("내용", question.getId());
            IdResponse<Long> answerLongIdResponse = answerService.create(answerRequest);
            Answer answer = answerQueryRepository.findById(answerLongIdResponse.getId()).get();

            AnswerCommentRequest answerCommentRequest =
                    new AnswerCommentRequest("내용", answer.getId());
            IdResponse<Long> answerCommentLongIdResponse =
                    answerCommentService.create(answerCommentRequest);
            AnswerComment answerComment =
                    answerCommentQueryRepository
                            .findById(answerCommentLongIdResponse.getId())
                            .get();

            // when
            // 아래 부분에서 오류 발생
            log.info("{}", answerComment.getId());
            log.info("{}", answerCommentLongIdResponse.getId());
            answerCommentService.deleteById(answerCommentLongIdResponse.getId());

            // then;
            assertThat(answerCommentQueryRepository.findById(answerCommentLongIdResponse.getId()))
                    .isEmpty();
        }
    }
}
