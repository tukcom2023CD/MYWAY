package shop.tukoreamyway.back.domain.ability.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.ability.dto.AbilityServiceRequest;
import shop.tukoreamyway.back.domain.ability.entity.Ability;
import shop.tukoreamyway.back.domain.ability.mapper.AbilityMapper;
import shop.tukoreamyway.back.global.CommandService;
import shop.tukoreamyway.back.global.IdResponse;

@CommandService
@RequiredArgsConstructor
public class AbilityService {
    private final AbilityRepository abilityRepository;
    private final AbilityMapper abilityMapper;

    public IdResponse<Long> create(AbilityServiceRequest dto) {
        Ability ability = abilityRepository.save(abilityMapper.toEntity(dto));
        return new IdResponse<>(ability.getId());
    }
}
