package shop.tukoreamyway.back.domain.ability.command.application;

import shop.tukoreamyway.back.domain.ability.entity.Ability;

public interface AbilityRepository {
    Ability save(Ability ability);
}
