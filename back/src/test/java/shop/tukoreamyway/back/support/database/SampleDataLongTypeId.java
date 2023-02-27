package shop.tukoreamyway.back.support.database;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SampleDataLongTypeId {
    TEAM1(500001L),
    STAFF1(400001L),
    STAFF2(400002L),
    STAFF3(400003L),
    STAFF4(400004L),
    STAFF5(400005L),

    PROJECT1(700001L),

    SPRINT1(600001L),

    TASK1(50001L)
    ;

    private Long id;
}
