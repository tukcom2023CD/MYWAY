package shop.tukoreamyway.back.team;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.team.dto.TeamRequest;
import shop.tukoreamyway.back.team.dto.TeamResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("teams")
public class TeamController {
    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamResponse> save(@RequestBody @Valid TeamRequest dto) {
        TeamResponse result = teamService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
