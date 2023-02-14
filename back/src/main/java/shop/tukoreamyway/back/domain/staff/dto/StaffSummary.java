package shop.tukoreamyway.back.domain.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StaffSummary {
    private Long id;
    private String name;
    private String rank;
}
