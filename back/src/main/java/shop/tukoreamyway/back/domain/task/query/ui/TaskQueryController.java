package shop.tukoreamyway.back.domain.task.query.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.tukoreamyway.back.domain.task.dto.MyTaskCondition;
import shop.tukoreamyway.back.domain.task.dto.TaskResponse;
import shop.tukoreamyway.back.domain.task.dto.TaskSearchCondition;
import shop.tukoreamyway.back.domain.task.dto.TaskSummary;
import shop.tukoreamyway.back.domain.task.query.application.TaskQueryService;
import shop.tukoreamyway.back.global.RequestObjectParam;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tasks")
public class TaskQueryController {
    private final TaskQueryService taskQueryService;

    @GetMapping
    public ResponseEntity<List<TaskSummary>> getAllByCondition(@RequestObjectParam TaskSearchCondition condition) {
        return ResponseEntity.ok(taskQueryService.findAllByCondition(condition));
    }

    @GetMapping("mytask")
    public ResponseEntity<List<TaskSummary>> getAllMyTask(@RequestObjectParam MyTaskCondition condition) {
        return ResponseEntity.ok(taskQueryService.findAllMyTask(condition));
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(taskQueryService.findById(id));
    }


}
