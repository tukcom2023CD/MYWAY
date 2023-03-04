package shop.tukoreamyway.back.domain.question.command.ui;

import static org.mockito.ArgumentMatchers.any;
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

import shop.tukoreamyway.back.domain.question.command.application.QuestionService;
import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
import shop.tukoreamyway.back.domain.question.dto.UpdateQuestionRequest;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.nio.charset.StandardCharsets;
import java.util.List;

@WebMvcTest(QuestionController.class)
@DisplayName("QuestionController에서")
class QuestionControllerTest extends RestDocumentTest {
    @MockBean QuestionService questionService;

    @Test
    @DisplayName("question 생성을 수행하는가")
    void successCreate() throws Exception {
        // given
        List<String> tags = List.of("커뮤니케이션", "개발");
        QuestionRequest req = new QuestionRequest("이거 어케함?", 2L, "아무튼 알려줘 벅벅", 2L, tags);
        when(questionService.create(any())).thenReturn(new IdResponse<>(5L));

        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/questions")
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(StandardCharsets.UTF_8)
                                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("create question", getDocumentRequest(), getDocumentResponse()));
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
    @DisplayName("question 삭제를 수행하는가")
    void successDeleteQuestion() throws Exception {
        // given
        // when

        ResultActions perform =
                mockMvc.perform(RestDocumentationRequestBuilders.delete("/questions/{id}", 5L));
        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(document("delete question", getDocumentRequest(), getDocumentResponse()));
    }
}
