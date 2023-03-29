package shop.tukoreamyway.back.domain.ability.command.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.ability.dto.AbilityRequest;
import shop.tukoreamyway.back.domain.ability.entity.Ability;
import shop.tukoreamyway.back.domain.ability.mapper.AbilityMapper;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.global.service.CommandService;
import shop.tukoreamyway.back.global.service.EntityLoader;

import java.util.Optional;

@CommandService
@RequiredArgsConstructor
public class AbilityService {
    private final AbilityRepository abilityRepository;
    private final AbilityMapper abilityMapper;
    private final EntityLoader<Staff, Long> staffLoader;

    public IdResponse<Long> create(final AbilityRequest dto) {
        final Staff receiver = staffLoader.getEntity(dto.getReceiverId());
        final Staff grantor =
                Optional.ofNullable(dto.getGrantorId()).map(staffLoader::getEntity).orElse(null);
        final Ability ability =
                abilityRepository.save(abilityMapper.toEntity(dto, receiver, grantor));
        return new IdResponse<>(ability.getId());
    }
}
