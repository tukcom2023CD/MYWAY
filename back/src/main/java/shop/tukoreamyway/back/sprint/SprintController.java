package shop.tukoreamyway.back.sprint;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.sprint.dto.SprintRequest;
import shop.tukoreamyway.back.sprint.dto.SprintResponse;
import shop.tukoreamyway.back.sprint.dto.SprintSummary;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sprints")
public class SprintController {
    private final SprintService sprintService;

    @PostMapping
    public ResponseEntity<SprintSummary> saveSprint(@RequestBody @Valid  SprintRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sprintService.create(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<SprintResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(sprintService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<SprintSummary>> getByProjectId(@RequestParam Long projectId) {
        return ResponseEntity.ok(sprintService.findAllByProjectId(projectId));
    }
}
