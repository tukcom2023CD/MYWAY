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

import shop.tukoreamyway.back.domain.question.dto.QuestionResponse;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryService;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.util.List;

@WebMvcTest(AnswerQueryController.class)
@DisplayName("AnswerQueryController에서")
class AnswerQueryControllerTest extends RestDocumentTest {
    @MockBean private QuestionQueryService questionQueryService;

    @Test
    @DisplayName("staff-id를 통한 전체 조회를 수행하는가")
    void successGetByStaffId() throws Exception {
        // given
        when(questionQueryService.findAllByWriterId(3L))
                .thenReturn(
                        List.of(
                                new QuestionResponse(
                                        1L,
                                        2L,
                                        "개강하기 싫으면 어떻게 할까요",
                                        3L,
                                        "벌써 3월이네",
                                        4L,
                                        List.of("문제해결"))));
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

    /*
    @Test
    @DisplayName("question-id를 통한 상세 조회를 수행하는가")
    void successGetByQuestionId() throws Exception {
        OAuth2Info oAuth2Info = new OAuth2Info(AuthProvider.KAKAO,"이거 맞나?");
        Member member = new Member(oAuth2Info);
        Question question = new Question("제목", "내용", new Staff(new Team("나", member, IT), new Member(oAuth2Info)), 3L);
        // given
        when(questionQueryService.findQuestionById(any())
                .        // when
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
    */
}
