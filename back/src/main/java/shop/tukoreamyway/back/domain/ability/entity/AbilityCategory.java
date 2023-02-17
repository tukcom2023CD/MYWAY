package shop.tukoreamyway.back.domain.ability.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AbilityCategory {
    COMMUNICATION("커뮤니케이션"),
    CRISIS_RESPONSE("위기 대처"),
    DEVELOPMENT("개발"),
    REFACTORING("리펙터링"),
    PLANNING("기획")
    ;
    private final String name;
}
