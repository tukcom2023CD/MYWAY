package shop.tukoreamyway.back.domain.team.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import shop.tukoreamyway.back.domain.team.entity.IndustryGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
    @NotBlank private String name;
    @NotNull private IndustryGroup industryGroup;
}
