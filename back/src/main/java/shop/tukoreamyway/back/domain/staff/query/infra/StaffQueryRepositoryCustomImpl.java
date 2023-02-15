package shop.tukoreamyway.back.domain.staff.query.infra;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.util.List;
import java.util.UUID;

import static shop.tukoreamyway.back.domain.member.entity.QMember.member;
import static shop.tukoreamyway.back.domain.staff.entity.QStaff.staff;
import static shop.tukoreamyway.back.domain.team.entity.QTeam.team;

@Repository
@RequiredArgsConstructor
public class StaffQueryRepositoryCustomImpl implements StaffQueryRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<Staff> findAllByTeamIdApplyFilter(Long teamId) {
        return jpaQueryFactory
                .selectFrom(staff)
                .join(staff.team, team).fetchJoin()
                .join(staff.member, member).fetchJoin()
                .where(
                        staff.team.id.eq(teamId)
                                .and(staff.isAcceptMember.isTrue())
                                .and(staff.isAcceptTeam.isFalse())
                ).fetch();
    }

    @Override
    public List<Staff> findAllByMemberIdInviteFilter(UUID memberId) {
        return jpaQueryFactory
                .selectFrom(staff)
                .join(staff.team, team).fetchJoin()
                .join(staff.member, member).fetchJoin()
                .where(
                        staff.member.id.eq(memberId)
                                .and(staff.isAcceptMember.isFalse())
                                .and(staff.isAcceptTeam.isTrue())
                ).fetch();
    }

    @Override
    public List<Staff> findAllActiveStaffByTeamId(Long teamId) {
        return jpaQueryFactory
                .selectFrom(staff)
                .join(staff.team, team).fetchJoin()
                .join(staff.member, member).fetchJoin()
                .where(
                        staff.team.id.eq(teamId)
                                .and(staff.isAcceptMember.isTrue())
                                .and(staff.isAcceptTeam.isTrue())
                ).fetch();
    }
}
