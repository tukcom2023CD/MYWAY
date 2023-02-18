package shop.tukoreamyway.back.domain.ability.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GrantLocation {
    TEAM_LEADER_DISCRETION("팀리더 재량"),
    PROJECT_MANAGER_DISCRETION("프로젝트 매니저 재량"),
    SPRINT_LEADER_DISCRETION("스프린트리더 재량"),
    DO_TASK("테스크 수행"),
    WRITE_QUESTION("질문지 작성"),
    WRITE_ANSWER("질문 답변"),
    ETC("기타");

    private final String name;
}
