package shop.tukoreamyway.back.member.query.infra;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shop.tukoreamyway.back.member.command.domain.Member;

import java.util.Optional;
import java.util.UUID;

import static shop.tukoreamyway.back.member.command.domain.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberDao {
    private final JPAQueryFactory jpaQueryFactory;

    public Optional<Member> findByIdId(UUID uuid) {
        Member result = jpaQueryFactory.selectFrom(member)
                .where(member.id.id.eq(uuid))
                .fetchFirst();

        return Optional.ofNullable(result);
    }
}
