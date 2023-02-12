package shop.tukoreamyway.back.project;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.project.dto.ProjectRequest;
import shop.tukoreamyway.back.project.dto.ProjectResponse;
import shop.tukoreamyway.back.project.dto.ProjectSummary;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("projects")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectSummary> saveProject(@RequestBody @Valid ProjectRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.create(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjectResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProjectSummary>> getAllByTeamID(@RequestParam Long teamId) {
        return ResponseEntity.ok(projectService.findAllByTeamId(teamId));
    }
}
