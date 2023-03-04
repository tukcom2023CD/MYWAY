package shop.tukoreamyway.back.domain.ability.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import shop.tukoreamyway.back.domain.ability.dto.AbilityRequest;
import shop.tukoreamyway.back.domain.ability.dto.AbilityResponse;
import shop.tukoreamyway.back.domain.ability.dto.AbilitySummary;
import shop.tukoreamyway.back.domain.ability.entity.Ability;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.util.Map;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AbilityMapper {
    Ability toEntity(AbilityRequest dto);

    Ability toEntity(AbilityRequest dto, Staff receiver, Staff grantor);

    AbilityResponse toResponse(Ability entity);

    AbilitySummary toSummary(Staff receiver, Map<AbilityCategory, Long> points);
}
