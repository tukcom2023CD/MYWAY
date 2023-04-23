package shop.tukoreamyway.back.domain.sprint.query.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.tukoreamyway.back.domain.sprint.dto.SprintResponse;
import shop.tukoreamyway.back.domain.sprint.query.application.SprintQueryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sprints")
public class SprintQueryController {
    private final SprintQueryService sprintQueryService;

    @GetMapping
    public ResponseEntity<List<SprintResponse>> getSprints(@RequestParam(name = "project-id") Long projectId) {
        return ResponseEntity.ok(sprintQueryService.findAllByProjectId(projectId));
    }
}
