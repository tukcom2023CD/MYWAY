package shop.tukoreamyway.back.domain.project.query.ui;

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

import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;
import shop.tukoreamyway.back.domain.project.query.application.ProjectQueryService;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;
import shop.tukoreamyway.back.domain.staff.entity.Rank;
import shop.tukoreamyway.back.domain.team.dto.TeamSummary;
import shop.tukoreamyway.back.domain.team.entity.IndustryGroup;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.time.LocalDateTime;
import java.util.List;

@WebMvcTest(ProjectQueryController.class)
@DisplayName("ProjectQueryController에서")
class ProjectQueryControllerTest extends RestDocumentTest {
    @MockBean private ProjectQueryService projectQueryService;

    @Test
    @DisplayName("team-id를 통한 전체 조회를 수행하는가")
    void successGetByTeamId() throws Exception {
        // given
        TeamSummary team = new TeamSummary(7L, "어벤저스", IndustryGroup.IT.getName());
        when(projectQueryService.findAllByTeamId(7L))
                .thenReturn(
                        List.of(
                                new ProjectResponse(
                                        1L,
                                        "a프로젝트",
                                        LocalDateTime.now(),
                                        LocalDateTime.now().plusMonths(5),
                                        team,
                                        7,
                                        new StaffSummary(1L, "리더1", Rank.MANAGER.getName())),
                                new ProjectResponse(
                                        2L,
                                        "b프로젝트",
                                        LocalDateTime.now(),
                                        LocalDateTime.now().plusMonths(5),
                                        team,
                                        7,
                                        new StaffSummary(81L, "리더81", Rank.MANAGER.getName())),
                                new ProjectResponse(
                                        4L,
                                        "c프로젝트",
                                        LocalDateTime.now(),
                                        LocalDateTime.now().plusMonths(5),
                                        team,
                                        7,
                                        new StaffSummary(91L, "리더91", Rank.MANAGER.getName()))));
        // when
        ResultActions perform = mockMvc.perform(get("/projects").param("team-id", "7"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get project list by team id",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }
}
