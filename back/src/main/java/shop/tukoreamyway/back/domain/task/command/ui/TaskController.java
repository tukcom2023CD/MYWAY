package shop.tukoreamyway.back.domain.task.command.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.domain.task.command.application.AllocateTaskRequest;
import shop.tukoreamyway.back.domain.task.command.application.TaskService;
import shop.tukoreamyway.back.domain.task.dto.TaskRequest;
import shop.tukoreamyway.back.domain.task.dto.UpdateTaskStatusRequest;
import shop.tukoreamyway.back.global.IdResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("tasks")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<IdResponse<Long>> createTask(@RequestBody @Valid TaskRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(dto));
    }

    @PostMapping("{id}/allocate")
    public ResponseEntity<Void> allocateTask(@RequestBody @Valid AllocateTaskRequest dto, @PathVariable Long id) {
        taskService.allocate(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{id}/bring")
    public ResponseEntity<Void> bringTask(@PathVariable Long id) {
        taskService.bring(id);
        return ResponseEntity.noContent().build();
    }

    //task 상태 변경
    @PatchMapping("{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestBody @Valid UpdateTaskStatusRequest dto) {
        taskService.updateStatus(id, dto);
        return ResponseEntity.noContent().build();
    }

}
