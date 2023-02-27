package shop.tukoreamyway.back.domain.project.command.ui;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.tukoreamyway.back.domain.project.command.application.ProjectService;
import shop.tukoreamyway.back.domain.project.dto.ProjectRequest;
import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("projects")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody @Valid final ProjectRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.create(dto));
    }
}
