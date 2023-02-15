package shop.tukoreamyway.back.domain.project.command.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.domain.project.command.application.ProjectService;
import shop.tukoreamyway.back.domain.project.dto.ProjectRequest;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

@WebMvcTest(ProjectController.class)
@DisplayName("ProjectController에서")
class ProjectControllerTest extends RestDocumentTest {
    @MockBean
    private ProjectService projectService;

    @Test
    @DisplayName("생성을 수행하는가")
    void successCreate() throws Exception {
        //given
        ProjectRequest req = new ProjectRequest("어벤져스 프로젝트", LocalDateTime.now(), LocalDateTime.now().plusMonths(5), 4L, 5, 7L);
        ResultActions perform = mockMvc.perform(post("/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8)
                .content(toRequestBody(req)));

        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("create project", getDocumentRequest(), getDocumentResponse()));
    }

}