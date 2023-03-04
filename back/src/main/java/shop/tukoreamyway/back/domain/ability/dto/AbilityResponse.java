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
    private final Long id;
    private final String category;
    private final StaffSummary receiver;
    private final Long point;
    private final LocalDateTime grantedAt;
    private final String grantLocation;
    private final StaffSummary grantor;
}
