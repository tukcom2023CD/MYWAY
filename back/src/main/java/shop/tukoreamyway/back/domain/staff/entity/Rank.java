package shop.tukoreamyway.back.domain.staff.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Rank {
    CLERK("사원"),
    SENIOR("주임"),
    ASSISTANT("대리"),
    MANAGER("과장"),
    DEPUTY_GENERAL_MANAGER("차장");

    private final String name;
}
