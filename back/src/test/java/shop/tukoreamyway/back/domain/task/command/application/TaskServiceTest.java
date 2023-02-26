package shop.tukoreamyway.back.domain.task.command.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryRepository;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;
import shop.tukoreamyway.back.domain.task.dto.AllocateTaskRequest;
import shop.tukoreamyway.back.domain.task.dto.TaskRequest;
import shop.tukoreamyway.back.domain.task.dto.UpdateTaskStatusRequest;
import shop.tukoreamyway.back.domain.task.entity.Task;
import shop.tukoreamyway.back.domain.task.entity.TaskStatus;
import shop.tukoreamyway.back.domain.task.query.application.TaskQueryRepository;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;
import shop.tukoreamyway.back.support.database.UseSampleData;

import javax.persistence.EntityNotFoundException;

@EnableDataBaseTest
@DisplayName("TaskService에서")
class TaskServiceTest extends LoginTest {
    @Autowired TaskService taskService;

    @Autowired TaskQueryRepository taskRepository;

    @MockBean StaffQueryService staffQueryService;

    @Autowired StaffQueryRepository staffQueryRepository;

    @Nested
    @DisplayName("create 호출 시")
    class CallCreate {
        @Test
        @DisplayName("저장을 수행하는가")
        @UseSampleData
        void successSave() throws Exception {
            // given
            TaskRequest req =
                    new TaskRequest(
                            "요약", "내용", 50, AbilityCategory.DEVELOPMENT, 600001L, null, null);
            // when
            IdResponse<Long> longIdResponse = taskService.create(req);
            // then
            assertThat(longIdResponse).isNotNull();
        }
    }

    @Test
    @DisplayName("할당을 수행하는가")
    @UseSampleData
    void successAllocate() throws Exception {
        // given
        TaskRequest req =
                new TaskRequest("요약", "내용", 50, AbilityCategory.DEVELOPMENT, 600001L, null, null);
        Long taskId = taskService.create(req).getId();
        AllocateTaskRequest allocateReq = new AllocateTaskRequest(400003L);
        Staff staff =
                staffQueryRepository.findById(400003L).orElseThrow(EntityNotFoundException::new);
        given(staffQueryService.getEntity(any())).willReturn(staff);
        // when
        taskService.allocate(taskId, allocateReq);
        // then
        Task result = taskRepository.findById(taskId).orElseThrow(EntityNotFoundException::new);
        assertThat(result.getPlayer().getId()).isEqualTo(allocateReq.getStaffId());
    }

    @Test
    @DisplayName("가져오기를 수행하는가")
    @UseSampleData
    void successBring() throws Exception {
        // given
        TaskRequest req =
                new TaskRequest("요약", "내용", 50, AbilityCategory.DEVELOPMENT, 600001L, null, null);
        Long taskId = taskService.create(req).getId();
        Staff staff =
                staffQueryRepository.findById(400003L).orElseThrow(EntityNotFoundException::new);
        given(staffQueryService.getActiveStaff(any())).willReturn(staff);
        // when
        taskService.bring(taskId);
        // then
        Task result = taskRepository.findById(taskId).orElseThrow(EntityNotFoundException::new);
        assertThat(result.getPlayer().getId()).isEqualTo(staff.getId());
    }

    @Test
    @DisplayName("상태 변경을 수행하는가")
    @UseSampleData
    void successUpdateStatus() throws Exception {
        // given
        TaskRequest req =
                new TaskRequest("요약", "내용", 50, AbilityCategory.DEVELOPMENT, 600001L, null, null);
        Long taskId = taskService.create(req).getId();
        UpdateTaskStatusRequest updateReq = new UpdateTaskStatusRequest(TaskStatus.PROGRESS);
        // when
        taskService.updateStatus(taskId, updateReq);
        // then
        Task result = taskRepository.findById(taskId).orElseThrow(EntityNotFoundException::new);
        assertThat(result.getStatus()).isEqualTo(updateReq.getStatus());
    }
}
