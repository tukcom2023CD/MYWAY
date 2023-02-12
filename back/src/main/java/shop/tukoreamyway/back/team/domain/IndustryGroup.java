package shop.tukoreamyway.back.team.domain;

import lombok.Getter;

@Getter
public enum IndustryGroup {
    IT("IT");
    private final String name;

    IndustryGroup(String name) {
        this.name = name;
    }
}
