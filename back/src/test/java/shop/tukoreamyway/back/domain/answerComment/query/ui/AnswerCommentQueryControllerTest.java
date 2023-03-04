package shop.tukoreamyway.back.domain.answerComment.query.ui;

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

import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentResponse;
import shop.tukoreamyway.back.domain.answercomment.query.application.AnswerCommentQueryService;
import shop.tukoreamyway.back.domain.answercomment.query.ui.AnswerCommentQueryController;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;
import shop.tukoreamyway.back.support.fixture.staff.StaffSummaryFixture;

import java.util.List;

@WebMvcTest(AnswerCommentQueryController.class)
@DisplayName("AnswerCommentQueryController에서")
class AnswerCommentQueryControllerTest extends RestDocumentTest {

    @MockBean private AnswerCommentQueryService answerCommentQueryService;

    @Test
    @DisplayName("answer에 있는 모든 answer-comment를 조회하는가")
    void successGetAllByWriterId() throws Exception {
        StaffSummary writer = StaffSummaryFixture.CAPTAIN.toDto();
        // given
        Long id = 1L;
        when(answerCommentQueryService.findById(any()))
                .thenReturn(new AnswerCommentResponse(2L, "내용", 5L, writer));
        // when
        ResultActions perform =
                mockMvc.perform(RestDocumentationRequestBuilders.get("/answer-comments/{id}", id));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get answer-comment list by answer-id",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("answer-comment id로 answer-comment를 조회하는가")
    void successGetById() throws Exception {
        StaffSummary writer = StaffSummaryFixture.CAPTAIN.toDto();
        // given
        Long id = 1L;
        when(answerCommentQueryService.findById(any()))
                .thenReturn(
                        List.of(
                                new AnswerCommentResponse(2L, "내용1", 5L, writer),
                                new AnswerCommentResponse(3L, "내용2", 6L, writer)));
        // when
        ResultActions perform =
                mockMvc.perform(RestDocumentationRequestBuilders.get("/answer-comments/{id}", id));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get answer-comment by id",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
