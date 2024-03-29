package shop.tukoreamyway.back.domain.answer.command.ui;

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

import shop.tukoreamyway.back.domain.answer.command.application.AnswerService;
import shop.tukoreamyway.back.domain.answer.dto.AnswerRequest;
import shop.tukoreamyway.back.domain.answer.dto.UpdateAnswerRequest;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.nio.charset.StandardCharsets;

@WebMvcTest(AnswerController.class)
@DisplayName("AnswerController에서")
class AnswerControllerTest extends RestDocumentTest {
    @MockBean AnswerService answerService;

    @Test
    @DisplayName("answer 생성을 수행하는가")
    void successCreate() throws Exception {
        // given
        AnswerRequest req = new AnswerRequest("그거 그렇게 하는거 아닌데", 1L);
        when(answerService.create(new AnswerRequest())).thenReturn(new IdResponse<>(5L));
        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/answers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(StandardCharsets.UTF_8)
                                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("create answer", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("question 수정을 수행하는가")
    void successUpdateQuestion() throws Exception {
        // given
        UpdateAnswerRequest req = new UpdateAnswerRequest("바꾸는 내용");

        // when
        ResultActions perform =
                mockMvc.perform(
                        put("/answers/{id}", 4L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(StandardCharsets.UTF_8)
                                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(document("update answer", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("answer 삭제를 수행하는가")
    void successDeleteAnswer() throws Exception {
        // given
        // when

        ResultActions perform =
                mockMvc.perform(RestDocumentationRequestBuilders.delete("/answers/{id}", 5L));
        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(document("delete answer", getDocumentRequest(), getDocumentResponse()));
    }
}
