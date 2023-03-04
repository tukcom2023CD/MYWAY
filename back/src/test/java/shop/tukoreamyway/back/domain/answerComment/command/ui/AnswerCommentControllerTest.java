package shop.tukoreamyway.back.domain.answerComment.command.ui;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
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
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.ResultActions;

import shop.tukoreamyway.back.domain.answercomment.command.application.AnswerCommentService;
import shop.tukoreamyway.back.domain.answercomment.command.ui.AnswerCommentController;
import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentRequest;
import shop.tukoreamyway.back.domain.question.dto.UpdateQuestionRequest;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.nio.charset.StandardCharsets;

@WebMvcTest(AnswerCommentController.class)
@DisplayName("AnswerCommentController에서")
class AnswerCommentControllerTest extends RestDocumentTest {
    @MockBean AnswerCommentService answerCommentService;

    @Test
    @DisplayName("answer-comment 생성을 수행하는가")
    void successCreate() throws Exception {
        // given
        AnswerCommentRequest req = new AnswerCommentRequest("그거 그렇게 하는거 아닌데", 1L);
        when(answerCommentService.create(new AnswerCommentRequest()))
                .thenReturn(new IdResponse<>(5L));
        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/answer-comments")
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(StandardCharsets.UTF_8)
                                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "create answer-comment",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("answer-comment 수정을 수행하는가")
    void successUpdateQuestion() throws Exception {
        // given
        UpdateQuestionRequest req = new UpdateQuestionRequest("바꾸는 내용");

        // when
        ResultActions perform =
                mockMvc.perform(
                        put("/answer-comments/{id}", 4L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(StandardCharsets.UTF_8)
                                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "update answer-comment",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("answer-comment 삭제를 수행하는가")
    void successDeleteQuestion() throws Exception {
        // given
        // when

        ResultActions perform =
                mockMvc.perform(
                        RestDocumentationRequestBuilders.delete("/answer-comments/{Id}", 5L));
        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "delete answer-comment",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
