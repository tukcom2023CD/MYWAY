package shop.tukoreamyway.back.staff;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.member.dto.MemberSummary;
import shop.tukoreamyway.back.staff.dto.StaffResponse;
import shop.tukoreamyway.back.team.domain.IndustryGroup;
import shop.tukoreamyway.back.team.dto.TeamSummary;
import shop.tukoreamyway.back.staff.dto.InviteTeamRequest;
import shop.tukoreamyway.back.staff.dto.InviteResponse;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

@WebMvcTest(StaffController.class)
@DisplayName("StaffControllerTest에서")
class StaffControllerTest extends RestDocumentTest {
    @MockBean
    private StaffService staffService;

    @Test
    @DisplayName("invite를 수행하는가")
    void successSave() throws Exception {
        //given
        InviteTeamRequest requestBody = new InviteTeamRequest(5L, Set.of(UUID.randomUUID(), UUID.randomUUID()));
        //when
        ResultActions perform = mockMvc.perform(post("/staffs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toRequestBody(requestBody)));
        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("invite team", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("로그인 한 유저의 초대 정보를 가져오는가")
    void successGetInvites() throws Exception {
        //given
        List<InviteResponse> expected = List.of(
                new InviteResponse(1L, new TeamSummary(2L, "네이버", IndustryGroup.IT.getName())),
                new InviteResponse(2L, new TeamSummary(4L, "카카오", IndustryGroup.IT.getName())),
                new InviteResponse(3L, new TeamSummary(6L, "라인", IndustryGroup.IT.getName())),
                new InviteResponse(4L, new TeamSummary(8L, "배민", IndustryGroup.IT.getName()))
        );
        when(staffService.findLoginUserInvites()).thenReturn(expected);
        //when
        ResultActions perform = mockMvc.perform(get("/staffs/auth-user"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get invite list", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("그룸 초대 수락을 제대로 수행하는가")
    void successAcceptInvite() throws Exception {
        //given
        //when
        ResultActions perform = mockMvc.perform(post("/staffs/{id}/accept", 5));
        // then
        perform.andExpect(status().isNoContent());
        // docs
        perform.andDo(print())
                .andDo(document("accept invite", getDocumentRequest(), getDocumentResponse()));
    }


    @Test
    @DisplayName("그룹에 속한 맴버들을 가져오는가")
    void successGetByOrganizationId() throws Exception {
        //given
        StaffResponse expected = new StaffResponse
                (new TeamSummary(5L, "카카오", IndustryGroup.IT.getName()),
                        List.of(
                                new MemberSummary(UUID.randomUUID(), "홍길동"),
                                new MemberSummary(UUID.randomUUID(), "춘향"),
                                new MemberSummary(UUID.randomUUID(), "라이언")
                        )
                );
        when(staffService.findByOrganizationId(any())).thenReturn(expected);
        //when
        ResultActions perform = mockMvc.perform(get("/staffs")
                .param("team-id", "5"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get staff list", getDocumentRequest(), getDocumentResponse()));

    }

}