package shop.tukoreamyway.back.domain.task.command.ui;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.task.command.application.TaskService;
import shop.tukoreamyway.back.domain.task.dto.AllocateTaskRequest;
import shop.tukoreamyway.back.domain.task.dto.TaskRequest;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.nio.charset.StandardCharsets;

@WebMvcTest(TaskController.class)
@DisplayName("TaskController에서")
class TaskControllerTest extends RestDocumentTest {
    @MockBean private TaskService taskService;

    @Test
    @DisplayName("task 생성을 수행하는가")
    void successCreateTask() throws Exception {
        // given
        TaskRequest req = new TaskRequest("요약", "설명", 50, AbilityCategory.DEVELOPMENT, 5L, 5L, 5L);
        when(taskService.create(req)).thenReturn(new IdResponse<>(1L));
        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/tasks")
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(StandardCharsets.UTF_8)
                                .content(toRequestBody(req)));
        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("create task", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("task 할당을 수행하는가")
    void successAllocateTask() throws Exception {
        // given
        AllocateTaskRequest req = new AllocateTaskRequest(1L);
        // when
        ResultActions perform =
                mockMvc.perform(
                        post("/tasks/{id}/allocate", 1L)
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding(StandardCharsets.UTF_8)
                                .content(toRequestBody(req)));
        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(document("allocate task", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("task 가져오기를 수행하는가")
    void successBringTask() throws Exception {
        // given

        // when
        ResultActions perform = mockMvc.perform(post("/tasks/{id}/bring", 1L));
        // then
        perform.andExpect(status().isNoContent());

        // docs
        perform.andDo(print())
                .andDo(document("bring task", getDocumentRequest(), getDocumentResponse()));
    }
}
