package shop.tukoreamyway.back.domain.question.query.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

@WebMvcTest(QuestionQueryController.class)
@DisplayName("QuestionQueryController에서")
class QuestionQueryControllerTest extends RestDocumentTest {

    @Test
    public void testGetQuestionById() throws Exception {
        // Given
        Long questionId = 1L;

        ResultActions perform = mockMvc.perform(RestDocumentationRequestBuilders.get("/questions/{questionId}", questionId));


        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get question By Id",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
