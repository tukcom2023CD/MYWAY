package shop.tukoreamyway.back.domain.ability.command.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.domain.ability.command.application.AbilityRepository;
import shop.tukoreamyway.back.domain.ability.entity.Ability;

public interface JpaAbilityRepository extends AbilityRepository, JpaRepository<Ability, Long> {
}
