package shop.tukoreamyway.back.domain.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import shop.tukoreamyway.back.domain.staff.entity.Rank;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamLeaderRequest {
    @Setter private String name;

    @NotNull private Rank rank;
}
