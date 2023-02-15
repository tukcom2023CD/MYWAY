package shop.tukoreamyway.back.domain.team.command.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.domain.team.command.application.TeamService;
import shop.tukoreamyway.back.domain.team.dto.TeamRequest;
import shop.tukoreamyway.back.domain.team.entity.IndustryGroup;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
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
    @DisplayName("생성을 수행하는가")
    void successCreate() throws Exception {
        //given
        TeamRequest req = new TeamRequest("삼성전자", IndustryGroup.IT);
        IdResponse<Long> expected = new IdResponse<>(1L);
        when(teamService.create(req)).thenReturn(expected);
        ResultActions perform = mockMvc.perform(post("/teams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("create team", getDocumentRequest(), getDocumentResponse()));
    }
}