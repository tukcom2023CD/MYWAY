package shop.tukoreamyway.back.domain.team.command.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import shop.tukoreamyway.back.domain.team.dto.TeamRequest;
import shop.tukoreamyway.back.domain.team.entity.IndustryGroup;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.domain.team.query.application.TeamQueryRepository;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@EnableDataBaseTest
@DisplayName("TeamService 에서")
class TeamServiceTest extends LoginTest {
    @Autowired private TeamService teamService;
    @Autowired private TeamQueryRepository teamQueryRepository;

    @Nested
    @DisplayName("create 호출 시")
    class CallCreate {
        @Test
        @DisplayName("저장을 수행하는가")
        void successSave() {
            // given
            TeamRequest req = new TeamRequest("삼성전자", IndustryGroup.IT);
            // when
            IdResponse<Long> res = teamService.create(req);
            Team team = teamQueryRepository.findById(res.getId()).get();
            // then
            assertThat(team.getName()).isEqualTo(req.getName());
            assertThat(team.getIndustryGroup()).isEqualTo(req.getIndustryGroup());
            assertThat(team.getLeader()).isEqualTo(loginUser);
        }

        @Test
        @DisplayName("CreateAt이 자동 생성되는가")
        void successAuditing() throws Exception {
            // given
            TeamRequest req = new TeamRequest("삼성전자", IndustryGroup.IT);
            LocalDateTime now = LocalDateTime.now();
            // when
            IdResponse<Long> res = teamService.create(req);
            Team team = teamQueryRepository.findById(res.getId()).get();

            //then
            assertThat(team.getBaseTime().getCreatedAt().getDayOfMonth()).isEqualTo(now.getDayOfMonth());
        }
    }
}
