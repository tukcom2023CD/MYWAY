package shop.tukoreamyway.back.domain.answer.query.ui;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;

import shop.tukoreamyway.back.domain.answer.dto.AnswerResponse;
import shop.tukoreamyway.back.domain.answer.query.application.AnswerQueryService;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;
import shop.tukoreamyway.back.support.fixture.staff.StaffSummaryFixture;

import java.util.List;

@WebMvcTest(AnswerQueryController.class)
@DisplayName("AnswerQueryController에서")
class AnswerQueryControllerTest extends RestDocumentTest {
    @MockBean private AnswerQueryService answerQueryService;

    @Test
    @DisplayName("question-id를 통한 전체 조회를 수행하는가")
    void successGetAllByQuestionId() throws Exception {

        // given

        StaffSummary writer = StaffSummaryFixture.CAPTAIN.toDto();
        when(answerQueryService.findAllByQuestionId(1L))
                .thenReturn(List.of(new AnswerResponse(3L, "d", 3L, writer)));
        // when
        ResultActions perform = mockMvc.perform(get("/answers").param("question-id", "7"));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get answer by question id",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("answer-id를 통한 상세 조회를 수행하는가")
    void successGetById() throws Exception {

        // given
        StaffSummary writer = StaffSummaryFixture.CAPTAIN.toDto();
        when(answerQueryService.findById(1L)).thenReturn(new AnswerResponse(3L, "d", 3L, writer));
        // when
        ResultActions perform = mockMvc.perform(get("/answers").param("question-id", "7"));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get answer by answer id",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
