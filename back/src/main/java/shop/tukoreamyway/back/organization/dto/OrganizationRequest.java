package shop.tukoreamyway.back.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.organization.domain.IndustryGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationRequest {
    @NotBlank
    private String name;
    @NotNull
    private IndustryGroup industryGroup;

}
