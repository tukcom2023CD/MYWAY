package shop.tukoreamyway.back.domain.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import shop.tukoreamyway.back.domain.staff.entity.Rank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AcceptApplyRequest {
    private Rank rank;
}
