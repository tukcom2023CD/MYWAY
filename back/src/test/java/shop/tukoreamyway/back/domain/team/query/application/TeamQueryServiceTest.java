package shop.tukoreamyway.back.domain.team.query.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.tukoreamyway.back.domain.team.command.application.TeamRepository;
import shop.tukoreamyway.back.domain.team.entity.IndustryGroup;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;

import javax.persistence.EntityNotFoundException;

@EnableDataBaseTest
@DisplayName("TeamQueryService 에서")
class TeamQueryServiceTest extends LoginTest {
    @Nested
    @DisplayName("getEntity호출 시")
    class CallGetEntity {
        @Autowired private TeamQueryService teamQueryService;

        @Autowired private TeamRepository teamRepository;

        @Test
        @DisplayName("제대로 가져오는가")
        void successGetEntity() throws Exception {
            // given
            Team team = teamRepository.save(new Team("팀명", loginUser, IndustryGroup.IT));
            // when
            Team result = teamQueryService.getEntity(team.getId());
            // then
            assertThat(result).isEqualTo(team);
        }

        @Test
        @DisplayName("없는 id면 예외처리 하는가")
        void successNotFoundException() throws Exception {
            // given
            // when
            // then
            assertThrows(EntityNotFoundException.class, () -> teamQueryService.getEntity(12345L));
        }
    }
}
