package shop.tukoreamyway.back.support.database;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SampleDataUUIDTypeId {

    MEMBER1(UUID.fromString("791ae85a-d8d0-11e2-8c43-50e549c9b654")),
    MEMBER2(UUID.fromString("791ae85a-d8d0-11e2-8c43-50e549c9b652")),
    MEMBER3(UUID.fromString("791ae85a-d8d0-11e2-8c43-50e549c9b656")),
    MEMBER4(UUID.fromString("791ae85a-d8d0-11e2-8c43-50e549c9b677"))
    ;
    private UUID id;
}
