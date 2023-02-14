package shop.tukoreamyway.back.domain.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InviteRequest {
    private Long teamId;
    private Set<UUID> members;
}
