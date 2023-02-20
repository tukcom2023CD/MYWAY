package shop.tukoreamyway.back.domain.question.command.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

@WebMvcTest(QuestionController.class)
@DisplayName("QuestionController에서")
class QuestionControllerTest extends RestDocumentTest {

    @Test
    @DisplayName("question 생성을 수행하는가")
    void successCreate() throws Exception {
        // given
        List<String> tags = List.of("커뮤니케이션", "개발");
        QuestionRequest req = new QuestionRequest(1L, "이거 어케함?", "아무튼 알려줘 벅벅", 2L, tags);
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
                .andDo(
                        document(
                                "create question",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
