package shop.tukoreamyway.back.domain.staff.command.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.domain.staff.command.application.StaffService;
import shop.tukoreamyway.back.domain.staff.dto.AcceptApplyRequest;
import shop.tukoreamyway.back.domain.staff.dto.AcceptInviteRequest;
import shop.tukoreamyway.back.domain.staff.dto.ApplyRequest;
import shop.tukoreamyway.back.domain.staff.dto.InviteRequest;
import shop.tukoreamyway.back.domain.staff.entity.Rank;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.util.Set;
import java.util.UUID;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

@WebMvcTest(StaffController.class)
@DisplayName("StaffController에서")
class StaffControllerTest extends RestDocumentTest {
    @MockBean
    private StaffService staffService;

    @Test
    @DisplayName("team으로 staff 초대를 수행하는가")
    void successInvite() throws Exception {
        //given
        InviteRequest req = new InviteRequest(1L, Set.of(UUID.randomUUID(), UUID.randomUUID()));
        ResultActions perform = mockMvc.perform(post("/staffs/invite")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("invite team", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("team으로 staff 지원을 수행하는가")
    void successApply() throws Exception {
        //given
        ApplyRequest req = new ApplyRequest(1L);
        ResultActions perform = mockMvc.perform(post("/staffs/apply")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("apply team", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("초대 수락을 수행하는가")
    void successAcceptInvite() throws Exception {
        AcceptInviteRequest req = new AcceptInviteRequest("마장동장첸");
        ResultActions perform = mockMvc.perform(post("/staffs/{id}/accept-invite", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(document("accept invite team", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("지원 수락을 수행하는가")
    void successAcceptApply() throws Exception {
        AcceptApplyRequest req = new AcceptApplyRequest(Rank.ASSISTANT);
        ResultActions perform = mockMvc.perform(post("/staffs/{id}/accept-apply", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(document("accept apply team", getDocumentRequest(), getDocumentResponse()));
    }


}