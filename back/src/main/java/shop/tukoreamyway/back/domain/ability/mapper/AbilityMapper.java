package shop.tukoreamyway.back.domain.ability.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.domain.ability.dto.AbilityRequest;
import shop.tukoreamyway.back.domain.ability.dto.AbilityServiceRequest;
import shop.tukoreamyway.back.domain.ability.entity.Ability;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AbilityMapper {
    Ability toEntity(AbilityServiceRequest dto);
    Ability toEntity(AbilityRequest dto, Staff receiver, Staff grantor);
}
