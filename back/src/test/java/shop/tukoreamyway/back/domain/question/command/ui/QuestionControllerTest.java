package shop.tukoreamyway.back.domain.question.command.ui;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import shop.tukoreamyway.back.domain.question.command.application.QuestionService;
import shop.tukoreamyway.back.domain.question.dto.UpdateQuestionRequest;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.nio.charset.StandardCharsets;

@WebMvcTest(QuestionController.class)
@DisplayName("QuestionController에서")
class QuestionControllerTest extends RestDocumentTest {
    @MockBean private QuestionService questionService;

    @Test
    @DisplayName("생성을 수행하는가")
    void successCreate() throws Exception {
        // given
        //        QuestionRequest req = new QuestionRequest("어벤져스 프로젝트", LocalDateTime.now(),
        // LocalDateTime.now().plusMonths(5), 4L, 5, 7L);
        //        ResultActions perform = mockMvc.perform(post("/questions")
        //                .contentType(MediaType.APPLICATION_JSON)
        //                .characterEncoding(StandardCharsets.UTF_8)
        //                .content(toRequestBody(req)));
        //
        //        // then
        //        perform.andExpect(status().isCreated());
        //
        //        // docs
        //        perform.andDo(print())
        //                .andDo(document("create project", getDocumentRequest(),
        // getDocumentResponse()));
    }

    @Test
    @DisplayName("question 수정을 수행하는가")
    void successUpdateQuestion() throws Exception {
        // given
        UpdateQuestionRequest req = new UpdateQuestionRequest("바꾸는 내용");

        // when
        ResultActions perform =
                mockMvc.perform(
                        put("/questions/{id}", 4L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(StandardCharsets.UTF_8)
                                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(document("update question", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("삭제를 수행하는가")
    void successDeleteQuestion() throws Exception {

        // given

        // when

        // then

    }
}
