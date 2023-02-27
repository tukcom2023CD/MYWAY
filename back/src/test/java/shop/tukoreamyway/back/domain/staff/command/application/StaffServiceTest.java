package shop.tukoreamyway.back.domain.staff.command.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static shop.tukoreamyway.back.support.database.SampleDataLongTypeId.TEAM1;
import static shop.tukoreamyway.back.support.database.SampleDataUUIDTypeId.MEMBER1;
import static shop.tukoreamyway.back.support.database.SampleDataUUIDTypeId.MEMBER2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.tukoreamyway.back.domain.staff.dto.ApplyRequest;
import shop.tukoreamyway.back.domain.staff.dto.InviteRequest;
import shop.tukoreamyway.back.domain.staff.entity.Rank;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryRepository;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.global.service.EntityQueryService;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;
import shop.tukoreamyway.back.support.database.UseSampleData;

import java.util.List;
import java.util.Set;

@EnableDataBaseTest
@DisplayName("StaffService에서")
class StaffServiceTest extends LoginTest {
    @Autowired private StaffService staffService;
    @Autowired private EntityQueryService<Team, Long> teamService;
    @Autowired private StaffQueryRepository staffQueryRepository;

    @Nested
    @DisplayName("createProjectLeaderStaff 호출 시")
    class CallCreateProjectLeaderStaff {
        @Test
        @DisplayName("리더 스태프 생성을 진행하는가")
        @UseSampleData
        void successCreate() throws Exception {
            // given
            Team team = teamService.getEntity(TEAM1.getId());
            List<Staff> before = staffQueryRepository.findAll();
            // when
            staffService.createProjectLeaderStaff(team);
            // then
            Staff result =
                    staffQueryRepository.findAll().stream()
                            .filter(s -> !before.contains(s))
                            .findFirst()
                            .get();
            assertThat(result.getTeam()).isEqualTo(team);
            assertThat(result.getRank()).isEqualTo(Rank.MANAGER);
            assertThat(result.getIsAcceptTeam()).isTrue();
            assertThat(result.getIsAcceptMember()).isTrue();
            assertThat(result.getMember()).isEqualTo(loginUser);
        }
    }

    @Test
    @DisplayName("초대 전송을 수행하는가")
    @UseSampleData
    void successInvite() throws Exception {
        // given
        InviteRequest req =
                new InviteRequest(TEAM1.getId(), Set.of(MEMBER1.getId(), MEMBER2.getId()));
        List<Staff> before = staffQueryRepository.findAll();
        // when
        staffService.invite(req);
        // then
        Team team = teamService.getEntity(TEAM1.getId());

        List<Staff> after =
                staffQueryRepository.findAll().stream().filter(s -> !before.contains(s)).toList();

        assertThat(after.size()).isEqualTo(2);
        assertThat(after.get(0).getTeam()).isEqualTo(team);
        assertThat(after.get(0).getIsAcceptTeam()).isTrue();
        assertThat(after.get(0).getIsAcceptMember()).isFalse();
    }

    @Test
    @DisplayName("지원 전송을 수행하는가")
    @UseSampleData
    void successApply() throws Exception {
        // given
        ApplyRequest req = new ApplyRequest(TEAM1.getId());
        List<Staff> before = staffQueryRepository.findAll();
        // when
        staffService.apply(req);
        // then
        Team team = teamService.getEntity(TEAM1.getId());

        Staff result =
                staffQueryRepository.findAll().stream()
                        .filter(s -> !before.contains(s))
                        .findFirst()
                        .get();
        assertThat(result.getTeam()).isEqualTo(team);
        assertThat(result.getMember()).isEqualTo(loginUser);
        assertThat(result.getIsAcceptTeam()).isFalse();
        assertThat(result.getIsAcceptMember()).isTrue();
    }
}
