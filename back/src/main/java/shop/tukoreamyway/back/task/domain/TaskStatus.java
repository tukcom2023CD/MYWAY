package shop.tukoreamyway.back.task.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TaskStatus {
    READY("준비"),
    PROGRESS("진행중"),
    REVIEW("검토중"),
    FAIL("실패"),
    COMPLETE("완료");

    private final String name;
}
