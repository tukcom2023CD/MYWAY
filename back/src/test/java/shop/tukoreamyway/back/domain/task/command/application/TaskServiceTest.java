package shop.tukoreamyway.back.domain.task.command.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.tukoreamyway.back.domain.sprint.command.application.SprintRepository;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;

@EnableDataBaseTest
@DisplayName("TaskService에서")
class TaskServiceTest extends LoginTest {
    @Autowired TaskService taskService;
    @Autowired TaskRepository taskRepository;
    @Autowired SprintRepository sprintRepository;

    @Nested
    @DisplayName("create 호출 시")
    class CallCreate {
        @Test
        @DisplayName("저장을 수행하는가")
        void successSave() throws Exception {
            // given
            //            sprintRepository.save(new Sprint());
            //            TaskRequest req = new TaskRequest("요약", "내용", AbilityCategory.DEVELOPMENT,
            // );
            // when

            // then

        }
    }

    @Test
    @DisplayName("할당을 수행하는가")
    void successAllocate() throws Exception {
        // given

        // when

        // then

    }

    @Test
    @DisplayName("가져오기를 수행하는가")
    void successBring() throws Exception {
        // given

        // when

        // then

    }

    @Test
    @DisplayName("상태 변경을 수행하는가")
    void successUpdateStatus() throws Exception {
        // given

        // when

        // then

    }
}
