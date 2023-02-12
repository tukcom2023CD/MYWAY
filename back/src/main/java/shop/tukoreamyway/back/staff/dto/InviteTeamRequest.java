package shop.tukoreamyway.back.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InviteTeamRequest {
    @NotNull
    private Long teamId;
    private Set<UUID> members;
}
