package shop.tukoreamyway.back.domain.team.command.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.tukoreamyway.back.domain.team.command.application.TeamService;
import shop.tukoreamyway.back.domain.team.dto.TeamRequest;
import shop.tukoreamyway.back.global.IdResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("teams")
public class TeamController {
    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<IdResponse<Long>> createTeam(@RequestBody @Valid TeamRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.create(dto));
    }
}
