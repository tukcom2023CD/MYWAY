package shop.tukoreamyway.back.domain.ability.query.application;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.ability.entity.Ability;

import java.util.List;

public interface AbilityQueryRepository extends JpaRepository<Ability, Long>, AbilityQueryRepositoryCustom {
    List<Ability> findAllByReceiverId(Long receiverId);
}
