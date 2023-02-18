package shop.tukoreamyway.back.domain.ability.query.infra;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shop.tukoreamyway.back.domain.ability.query.application.AbilityQueryRepositoryCustom;

@Repository
@RequiredArgsConstructor
public class AbilityQueryRepositoryImpl implements AbilityQueryRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

}
