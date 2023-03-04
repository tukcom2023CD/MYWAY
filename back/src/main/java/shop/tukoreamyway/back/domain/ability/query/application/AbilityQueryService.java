package shop.tukoreamyway.back.domain.ability.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.ability.dto.AbilityResponse;
import shop.tukoreamyway.back.domain.ability.dto.AbilitySummary;
import shop.tukoreamyway.back.domain.ability.entity.Ability;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.ability.mapper.AbilityMapper;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.staff.query.application.StaffLoader;
import shop.tukoreamyway.back.global.service.EntityLoader;
import shop.tukoreamyway.back.global.service.QueryService;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@QueryService
@RequiredArgsConstructor
public class AbilityQueryService {
    private final AbilityQueryRepository abilityQueryRepository;
    private final EntityLoader<Staff, Long> staffLoader;
    private final StaffLoader activeStaffLoader;
    private final AbilityMapper abilityMapper;

    public List<AbilityResponse> findAllByStaffId(final Long staffId) {
        final List<Ability> abilities = abilityQueryRepository.findAllByReceiverId(staffId);
        return abilities.stream().map(abilityMapper::toResponse).toList();
    }

    public AbilitySummary findSummaryByStaffId(final Long staffId) {
        final List<Ability> abilities = abilityQueryRepository.findAllByReceiverId(staffId);
        final Staff receiver = staffLoader.getEntity(staffId);
        final Map<AbilityCategory, Long> points = generatePoints(abilities);
        return abilityMapper.toSummary(receiver, points);
    }

    private Map<AbilityCategory, Long> generatePoints(final List<Ability> abilities) {
        final Map<AbilityCategory, Long> points = new EnumMap<>(AbilityCategory.class);
        pointMapInitialize(points);
        abilities.forEach(
                ability -> points.compute(ability.getCategory(), (k, v) -> v + ability.getPoint()));
        return points;
    }

    private void pointMapInitialize(Map<AbilityCategory, Long> points) {
        Arrays.stream(AbilityCategory.values()).forEach(category -> points.put(category, 0L));
    }

    public List<AbilityResponse> findAllMyAbility(final Long teamId) {
        final Long receiverId = activeStaffLoader.getActiveStaff(teamId).getId();
        final List<Ability> abilities = abilityQueryRepository.findAllByReceiverId(receiverId);
        return abilities.stream().map(abilityMapper::toResponse).toList();
    }

    public AbilitySummary findAllMyAbilitySummary(final Long teamId) {
        final Staff receiver = activeStaffLoader.getActiveStaff(teamId);
        final List<Ability> abilities =
                abilityQueryRepository.findAllByReceiverId(receiver.getId());
        final Map<AbilityCategory, Long> points = generatePoints(abilities);
        return abilityMapper.toSummary(receiver, points);
    }
}
