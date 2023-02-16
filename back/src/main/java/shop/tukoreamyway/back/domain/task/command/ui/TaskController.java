package shop.tukoreamyway.back.domain.task.command.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.tukoreamyway.back.domain.task.command.application.TaskService;
import shop.tukoreamyway.back.domain.task.dto.TaskRequest;
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
}
