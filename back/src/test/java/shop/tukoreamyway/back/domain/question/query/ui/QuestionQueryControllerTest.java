package shop.tukoreamyway.back.domain.question.query.ui;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.ResultActions;

import shop.tukoreamyway.back.domain.question.dto.QuestionResponse;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryService;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;
import shop.tukoreamyway.back.support.fixture.staff.StaffSummaryFixture;

import java.util.List;

@WebMvcTest(QuestionQueryController.class)
@DisplayName("QuestionQueryController에서")
class QuestionQueryControllerTest extends RestDocumentTest {

    @MockBean private QuestionQueryService questionQueryService;

    @Test
    @DisplayName("작성자가 작성한 모든 question을 조회하는가")
    void successGetAllByWriterId() throws Exception {
        StaffSummary writer = StaffSummaryFixture.CAPTAIN.toDto();
        // given
        when(questionQueryService.findAllByWriterId(any()))
                .thenReturn(
                        List.of(
                                new QuestionResponse(
                                        2L, "제목", "내용", 5L, List.of("태그1", "태그2"), writer),
                                new QuestionResponse(
                                        3L, "제목", "내용", 5L, List.of("태그1", "태그2"), writer),
                                new QuestionResponse(
                                        4L, "제목", "내용", 5L, List.of("태그1", "태그2"), writer)));
        // when
        ResultActions perform =
                mockMvc.perform(
                        RestDocumentationRequestBuilders.get("/questions")
                                .param("writer-id", writer.getId().toString()));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get question list by writer id",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("question-id로 question을 조회하는가")
    void successGetById() throws Exception {
        StaffSummary writer = StaffSummaryFixture.CAPTAIN.toDto();
        // given
        Long id = 1L;
        when(questionQueryService.findById(any()))
                .thenReturn(
                        new QuestionResponse(2L, "제목", "내용", 5L, List.of("태그1", "태그2"), writer));
        // when
        ResultActions perform =
                mockMvc.perform(RestDocumentationRequestBuilders.get("/questions/{id}", id));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get question by question id",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
