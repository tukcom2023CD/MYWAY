package shop.tukoreamyway.back.team;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.member.dto.MemberSummary;
import shop.tukoreamyway.back.team.domain.IndustryGroup;
import shop.tukoreamyway.back.team.dto.*;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;
import shop.tukoreamyway.back.staff.StaffSummary;
import shop.tukoreamyway.back.staff.domain.Rank;

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

@WebMvcTest(TeamController.class)
@DisplayName("TeamController에서")
class TeamControllerTest extends RestDocumentTest {

    @MockBean
    private TeamService teamService;

    @Test
    @DisplayName("저장을 수행하는가")
    void successSave() throws Exception {
        //given
        TeamRequest requestBody = new TeamRequest("순양 그룹", IndustryGroup.IT);
        MemberSummary leader = new MemberSummary(UUID.randomUUID(), "진양철");
        TeamResponse expected = new TeamResponse(1L, "순양 그룹", leader, IndustryGroup.IT.getName(), List.of(new StaffSummary(5L, leader.getName(), Rank.ASSISTANT.getName())));
        when(teamService.create(any())).thenReturn(expected);
        //when
        ResultActions perform = mockMvc.perform(post("/teams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toRequestBody(requestBody)));

        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("create team", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("invite를 수행하는가")
    void successInvite() throws Exception {
        //given
        InviteRequest requestBody = new InviteRequest(Set.of(UUID.randomUUID(), UUID.randomUUID()));
        //when
        ResultActions perform = mockMvc.perform(post("/teams/{id}/invite", 5L)
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
        when(teamService.findLoginUserInvites()).thenReturn(expected);
        //when
        ResultActions perform = mockMvc.perform(get("/teams/invite"));
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
        ResultActions perform = mockMvc.perform(post("/teams/{id}/accept", 5));
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
        TeamResponse expected = new TeamResponse(5L, "카카오",
                new MemberSummary(UUID.randomUUID(), "리더"),
                IndustryGroup.IT.getName(),
                        List.of(
                                new StaffSummary(1L, "홍길동", Rank.MANAGER.getName()),
                                new StaffSummary(2L, "춘향", Rank.ASSISTANT.getName()),
                                new StaffSummary(3L, "라이언", Rank.SENIOR.getName())
                        )
                );
        when(teamService.findById(any())).thenReturn(expected);
        //when
        ResultActions perform = mockMvc.perform(get("/teams/{id}", 5L));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get team", getDocumentRequest(), getDocumentResponse()));
    }
}