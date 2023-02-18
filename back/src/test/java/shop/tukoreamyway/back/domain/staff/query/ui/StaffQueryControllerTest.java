package shop.tukoreamyway.back.domain.staff.query.ui;

import static org.mockito.ArgumentMatchers.any;
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

import shop.tukoreamyway.back.domain.member.dto.MemberSummary;
import shop.tukoreamyway.back.domain.staff.dto.StaffResponse;
import shop.tukoreamyway.back.domain.staff.entity.Rank;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.domain.team.dto.TeamSummary;
import shop.tukoreamyway.back.domain.team.entity.IndustryGroup;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.util.List;
import java.util.UUID;

@WebMvcTest(StaffQueryController.class)
@DisplayName("StaffQueryController에서")
class StaffQueryControllerTest extends RestDocumentTest {
    @MockBean private StaffQueryService staffQueryService;

    @Test
    @DisplayName("팀에 지원한 목록을 보여주는가")
    void successGetApplyList() throws Exception {
        // given

        TeamSummary team = new TeamSummary(7L, "어벤저스", IndustryGroup.IT.getName());
        when(staffQueryService.findAllApplyByTeamId(any()))
                .thenReturn(
                        List.of(
                                new StaffResponse(
                                        1L,
                                        "아이언맨",
                                        Rank.MANAGER.getName(),
                                        true,
                                        false,
                                        new MemberSummary(UUID.randomUUID(), "김철근"),
                                        team),
                                new StaffResponse(
                                        1L,
                                        "캡틴아메리카",
                                        Rank.MANAGER.getName(),
                                        true,
                                        false,
                                        new MemberSummary(UUID.randomUUID(), "박방패"),
                                        team),
                                new StaffResponse(
                                        1L,
                                        "토르",
                                        Rank.MANAGER.getName(),
                                        true,
                                        false,
                                        new MemberSummary(UUID.randomUUID(), "이망치"),
                                        team)));
        ResultActions perform = mockMvc.perform(get("/staffs/apply").param("team-id", "7"));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get apply staff list",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("팀에서 초대온 목록을 보여주는가")
    void successGetInviteList() throws Exception {
        // given
        MemberSummary member = new MemberSummary(UUID.randomUUID(), "이망치");
        when(staffQueryService.findAllInvite())
                .thenReturn(
                        List.of(
                                new StaffResponse(
                                        1L,
                                        "망치맨",
                                        Rank.MANAGER.getName(),
                                        false,
                                        true,
                                        member,
                                        new TeamSummary(9L, "철물점", IndustryGroup.IT.getName())),
                                new StaffResponse(
                                        1L,
                                        "뚝딱이",
                                        Rank.CLERK.getName(),
                                        false,
                                        true,
                                        member,
                                        new TeamSummary(8L, "용산 전자", IndustryGroup.IT.getName())),
                                new StaffResponse(
                                        1L,
                                        "토르",
                                        Rank.CLERK.getName(),
                                        false,
                                        true,
                                        member,
                                        new TeamSummary(7L, "어벤저스", IndustryGroup.IT.getName()))));
        ResultActions perform = mockMvc.perform(get("/staffs/invite"));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get invite staff list",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("팀원 목록을 보여주는가")
    void successGetTeamStaffList() throws Exception {
        // given
        TeamSummary team = new TeamSummary(7L, "어벤저스", IndustryGroup.IT.getName());
        when(staffQueryService.findAllTeamStaff(any()))
                .thenReturn(
                        List.of(
                                new StaffResponse(
                                        1L,
                                        "아이언맨",
                                        Rank.MANAGER.getName(),
                                        true,
                                        true,
                                        new MemberSummary(UUID.randomUUID(), "김철근"),
                                        team),
                                new StaffResponse(
                                        1L,
                                        "캡틴아메리카",
                                        Rank.MANAGER.getName(),
                                        true,
                                        true,
                                        new MemberSummary(UUID.randomUUID(), "박방패"),
                                        team),
                                new StaffResponse(
                                        1L,
                                        "토르",
                                        Rank.MANAGER.getName(),
                                        true,
                                        true,
                                        new MemberSummary(UUID.randomUUID(), "이망치"),
                                        team)));
        ResultActions perform = mockMvc.perform(get("/staffs").param("team-id", "7"));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get team staff list",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("본인이 현재 속한 팀을 보여주는가")
    void successGetMyTeam() throws Exception {
        // given
        MemberSummary member = new MemberSummary(UUID.randomUUID(), "이망치");
        when(staffQueryService.findAllMyTeam())
                .thenReturn(
                        List.of(
                                new StaffResponse(
                                        1L,
                                        "망치맨",
                                        Rank.MANAGER.getName(),
                                        true,
                                        true,
                                        member,
                                        new TeamSummary(9L, "철물점", IndustryGroup.IT.getName())),
                                new StaffResponse(
                                        1L,
                                        "뚝딱이",
                                        Rank.CLERK.getName(),
                                        true,
                                        true,
                                        member,
                                        new TeamSummary(8L, "용산 전자", IndustryGroup.IT.getName())),
                                new StaffResponse(
                                        1L,
                                        "토르",
                                        Rank.CLERK.getName(),
                                        true,
                                        true,
                                        member,
                                        new TeamSummary(7L, "어벤저스", IndustryGroup.IT.getName()))));
        ResultActions perform = mockMvc.perform(get("/staffs/myteam"));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get my staff list", getDocumentRequest(), getDocumentResponse()));
    }
}
