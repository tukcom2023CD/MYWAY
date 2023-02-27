package shop.tukoreamyway.back.domain.answer.query.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.domain.question.dto.QuestionResponse;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryService;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;
import shop.tukoreamyway.back.support.fixture.staff.StaffSummaryFixture;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

@WebMvcTest(AnswerQueryController.class)
@DisplayName("AnswerQueryController에서")
class AnswerQueryControllerTest extends RestDocumentTest {
    @MockBean
    private QuestionQueryService questionQueryService;

    @Test
    @DisplayName("staff-id를 통한 전체 조회를 수행하는가")
    void successGetByStaffId() throws Exception {
        // given
        StaffSummary writer = StaffSummaryFixture.THOR.toDto();
        when(questionQueryService.findAllByWriterId(writer.getId()))
                .thenReturn(
                        List.of(
                                new QuestionResponse(
                                        1L,
                                        "개강하기 싫으면 어떻게 할까요",
                                        "벌써 3월이네",
                                        4L,
                                        List.of("문제해결", "개발"),
                                        StaffSummaryFixture.THOR.toDto()
                                ),
                                new QuestionResponse(
                                        2L,
                                        "개강하기 싫으면 어떻게 할까요",
                                        "벌써 3월이네",
                                        4L,
                                        List.of("문제해결", "개발"),
                                        StaffSummaryFixture.THOR.toDto()

                                )

                        ));
        // when
        ResultActions perform = mockMvc.perform(get("/answers").param("question-id", "7"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get question list by staff id",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("question-id를 통한 상세 조회를 수행하는가")
    void successGetByQuestionId() throws Exception {
        StaffSummary writer = StaffSummaryFixture.THOR.toDto();
        // given
        when(questionQueryService.findQuestionById(any())).thenReturn(
                new QuestionResponse(
                        1L,
                        "개강하기 싫으면 어떻게 할까요",
                        "벌써 3월이네",
                        4L,
                        List.of("문제해결", "개발"),
                        StaffSummaryFixture.THOR.toDto()
                )
        );
        // when
        ResultActions perform = mockMvc.perform(get("/answers").param("staff-id", "7"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get question list by staff id",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
