package shop.tukoreamyway.back.domain.task.query.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.task.dto.MyTaskCondition;
import shop.tukoreamyway.back.domain.task.dto.TaskResponse;
import shop.tukoreamyway.back.domain.task.dto.TaskSearchCondition;
import shop.tukoreamyway.back.domain.task.entity.TaskStatus;
import shop.tukoreamyway.back.domain.task.query.application.TaskQueryService;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;
import shop.tukoreamyway.back.support.fixture.sprint.SprintResponseFixture;
import shop.tukoreamyway.back.support.fixture.staff.StaffSummaryFixture;
import shop.tukoreamyway.back.support.fixture.task.TaskSummaryFixture;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

@WebMvcTest(TaskQueryController.class)
@DisplayName("TaskQueryController에서")
class TaskQueryControllerTest extends RestDocumentTest {
    @MockBean private TaskQueryService taskQueryService;

    @Test
    @DisplayName("검색 조건으로 task를 가져오는가")
    void successGetAllByCondition() throws Exception {
        // given
        TaskSearchCondition condition =
                new TaskSearchCondition(TaskStatus.PROGRESS, AbilityCategory.DEVELOPMENT, 1L, 2L);
        when(taskQueryService.findAllByCondition(any()))
                .thenReturn(
                        List.of(
                                TaskSummaryFixture.SAMPLE1.toDto(),
                                TaskSummaryFixture.SAMPLE2.toDto(),
                                TaskSummaryFixture.SAMPLE3.toDto()));
        // when
        ResultActions perform =
                mockMvc.perform(
                        get("/tasks")
                                .param("status", "PROGRESS")
                                .param("category", "DEVELOPMENT")
                                .param("sprintId", "1")
                                .param("playerId", "2"));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get task list by condition",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("검잭 조건으로 본인의 task를 가져오는가")
    void successGetAllMyTask() throws Exception {
        // given
        MyTaskCondition condition =
                new MyTaskCondition(AbilityCategory.DEVELOPMENT, TaskStatus.PROGRESS, 1L, 2L);
        when(taskQueryService.findAllMyTask(any()))
                .thenReturn(
                        List.of(
                                TaskSummaryFixture.SAMPLE1.toDto(),
                                TaskSummaryFixture.SAMPLE2.toDto(),
                                TaskSummaryFixture.SAMPLE3.toDto()));
        // when
        ResultActions perform =
                mockMvc.perform(
                        get("/tasks/mytask")
                                .param("status", "PROGRESS")
                                .param("category", "DEVELOPMENT")
                                .param("sprintId", "1")
                                .param("teamId", "2"));

        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(
                        document(
                                "get my task list by condition",
                                getDocumentRequest(),
                                getDocumentResponse()));
    }

    @Test
    @DisplayName("id를 통한 상세조회를 수행하는가")
    void successGetById() throws Exception {
        // given
        when(taskQueryService.findById(1L))
                .thenReturn(
                        new TaskResponse(
                                1L,
                                "요약요약",
                                "설명",
                                TaskStatus.READY.getName(),
                                4,
                                AbilityCategory.DEVELOPMENT.getName(),
                                SprintResponseFixture.SAMPLE1.toDto(),
                                StaffSummaryFixture.CAPTAIN.toDto(),
                                StaffSummaryFixture.THOR.toDto()));
        // when
        ResultActions perform = mockMvc.perform(get("/tasks/{id}", 1));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get task", getDocumentRequest(), getDocumentResponse()));
    }
}
