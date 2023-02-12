package shop.tukoreamyway.back.team;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import shop.tukoreamyway.back.member.MemberRepository;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.fixture.MemberFixture;
import shop.tukoreamyway.back.support.fixture.TeamFixture;
import shop.tukoreamyway.back.team.domain.IndustryGroup;
import shop.tukoreamyway.back.team.domain.Team;
import shop.tukoreamyway.back.team.dto.InviteRequest;
import shop.tukoreamyway.back.team.dto.TeamRequest;
import shop.tukoreamyway.back.team.dto.TeamResponse;
import shop.tukoreamyway.back.team.staff.StaffRepository;
import shop.tukoreamyway.back.team.staff.domain.Staff;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("TeamService에서")
class TeamServiceTest extends LoginTest {
    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private StaffRepository staffRepository;

    @Test
    @DisplayName("저장을 수행하는가")
    void successSave() {
        //given
        TeamRequest req = new TeamRequest("영업 1팀", IndustryGroup.IT);
        //when
        TeamResponse teamResponse = teamService.create(req);
        Team team = teamRepository.findById(teamResponse.getId()).get();
        //then
        assertThat(teamResponse.getId()).isEqualTo(team.getId());
        assertThat(teamResponse.getName()).isEqualTo(team.getName());
        assertThat(teamResponse.getIndustryGroup()).isEqualTo(team.getIndustryGroup().getName());
        assertThat(teamResponse.getLeader().getId()).isEqualTo(team.getLeader().getId());
        assertThat(teamResponse.getLeader().getId()).isEqualTo(loginUser.getId());
    }

    @Test
    @DisplayName("초대 기능을 수행하는가")
    void successInvite() {
        //given
        Member teamLeader = memberRepository.save(MemberFixture.M1.toEntity());
        Member member2 = memberRepository.save(MemberFixture.M2.toEntity());
        Member member3 = memberRepository.save(MemberFixture.M3.toEntity());

        Team team = teamRepository.save(TeamFixture.T1.toEntity(teamLeader));

        InviteRequest req = new InviteRequest(Set.of(member2.getId(), member3.getId()));
        //when
        teamService.invite(team.getId(), req);
        //then
        List<Staff> staffs = staffRepository.findAll();
        assertThat(staffs).hasSize(2);
    }

    @Test
    @DisplayName("초대 수락 기능을 수행하는가")
    void successAccept() {
        //given
        Member teamLeader = memberRepository.save(MemberFixture.M1.toEntity());
        Team team = teamRepository.save(TeamFixture.T1.toEntity(teamLeader));
        InviteRequest req = new InviteRequest( Set.of(loginUser.getId()));
        teamService.invite(team.getId(), req);
        //when
        teamService.accept(team.getId());
        //then
        Staff staff = staffRepository.findAllByMember(loginUser).stream().findFirst().get();
        assertThat(staff.getIsAccept()).isTrue();
    }

    @Test
    @DisplayName("로그인 한 유저의 초대 목록을 보여주는가")
    void successFindLoginUserInvites() {
        //given
        Member teamLeader = memberRepository.save(MemberFixture.M1.toEntity());
        Team team = teamRepository.save(TeamFixture.T1.toEntity(teamLeader));
        Team team2 = teamRepository.save(TeamFixture.T2.toEntity(teamLeader));
        //when

        //then

    }

    @Test
    @DisplayName("team에 해당하는 유저 목록을 조회하는가")
    void successFindByTeamId() {
        //given

        //when

        //then

    }
}