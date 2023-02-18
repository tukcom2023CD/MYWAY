package shop.tukoreamyway.back.domain.question.command.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import shop.tukoreamyway.back.domain.question.command.application.QuestionService;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

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
}
