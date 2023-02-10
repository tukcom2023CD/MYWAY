package shop.tukoreamyway.back.organization.organizationmameber;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InviteOrganizationRequest {
    @NotNull
    private Long organizationId;
    private Set<UUID> members;
}
