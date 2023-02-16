package shop.tukoreamyway.back.domain.project.query.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;
import shop.tukoreamyway.back.domain.project.query.application.ProjectQueryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("projects")
public class ProjectQueryController {
    private final ProjectQueryService projectQueryService;
    @GetMapping(params = "team-id")
    public ResponseEntity<List<ProjectResponse>> getByTeamId(@RequestParam(name = "team-id") Long teamId) {
        return ResponseEntity.ok(projectQueryService.findAllByTeamId(teamId));
    }
}
