package shop.tukoreamyway.back.domain.staff.query.infra;

import static shop.tukoreamyway.back.domain.member.entity.QMember.member;
import static shop.tukoreamyway.back.domain.staff.entity.QStaff.staff;
import static shop.tukoreamyway.back.domain.team.entity.QTeam.team;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryRepositoryCustom;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class StaffQueryRepositoryImpl implements StaffQueryRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Staff> findAllByTeamIdApplyFilter(final Long teamId) {
        return jpaQueryFactory
                .selectFrom(staff)
                .join(staff.team, team)
                .fetchJoin()
                .join(staff.member, member)
                .fetchJoin()
                .where(
                        staff.team
                                .id
                                .eq(teamId)
                                .and(staff.isAcceptMember.isTrue())
                                .and(staff.isAcceptTeam.isFalse()))
                .fetch();
    }

    @Override
    public List<Staff> findAllByMemberIdInviteFilter(final UUID memberId) {
        return jpaQueryFactory
                .selectFrom(staff)
                .join(staff.team, team)
                .fetchJoin()
                .join(staff.member, member)
                .fetchJoin()
                .where(
                        staff.member
                                .id
                                .eq(memberId)
                                .and(staff.isAcceptMember.isFalse())
                                .and(staff.isAcceptTeam.isTrue()))
                .fetch();
    }

    @Override
    public List<Staff> findAllActiveStaffByTeamId(final Long teamId) {
        return jpaQueryFactory
                .selectFrom(staff)
                .join(staff.team, team)
                .fetchJoin()
                .join(staff.member, member)
                .fetchJoin()
                .where(
                        staff.team
                                .id
                                .eq(teamId)
                                .and(staff.isAcceptMember.isTrue())
                                .and(staff.isAcceptTeam.isTrue()))
                .fetch();
    }

    @Override
    public List<Staff> findAllActiveStaffByMemberId(final UUID memberId) {
        return jpaQueryFactory
                .selectFrom(staff)
                .join(staff.team, team)
                .fetchJoin()
                .join(staff.member, member)
                .fetchJoin()
                .where(
                        staff.member
                                .id
                                .eq(memberId)
                                .and(staff.isAcceptMember.isTrue())
                                .and(staff.isAcceptTeam.isTrue()))
                .fetch();
    }
}
