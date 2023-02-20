package shop.tukoreamyway.back.domain.answerComment.command.ui;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import shop.tukoreamyway.back.domain.answercomment.command.ui.AnswerCommentController;
import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentRequest;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.nio.charset.StandardCharsets;

@WebMvcTest(AnswerCommentController.class)
@DisplayName("AnswerCommentController에서")
class AnswerCommentControllerTest extends RestDocumentTest {

    @Test
    @DisplayName("answerComment 생성을 수행하는가")
    void successCreate() throws Exception {
        // given
        AnswerCommentRequest req = new AnswerCommentRequest("그거 그렇게 하는거 아닌데", 1L);
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
                                "create answerComment",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
