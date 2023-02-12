package shop.tukoreamyway.back.team;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.team.dto.InviteRequest;
import shop.tukoreamyway.back.team.dto.InviteResponse;
import shop.tukoreamyway.back.team.dto.TeamRequest;
import shop.tukoreamyway.back.team.dto.TeamResponse;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("{id}/invite")
    public ResponseEntity<Void> invite(@PathVariable Long id, @RequestBody @Valid InviteRequest dto) {
        teamService.invite(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/accept")
    public ResponseEntity<Void> accept(@PathVariable Long id) {
        teamService.accept(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("invite")
    public ResponseEntity<List<InviteResponse>> getInvites() {
        return ResponseEntity.ok(teamService.findLoginUserInvites());
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamResponse> getByTeamId(
            @PathVariable Long id) {
        return ResponseEntity.ok(teamService.findById(id));
    }
}
