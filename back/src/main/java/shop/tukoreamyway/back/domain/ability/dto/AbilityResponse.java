package shop.tukoreamyway.back.domain.ability.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class AbilityResponse {
    private Long id;
    private String category;
    private StaffSummary receiver;
    private Long point;
    private LocalDateTime grantedAt;
    private String grantLocation;
    private StaffSummary grantor;
}
