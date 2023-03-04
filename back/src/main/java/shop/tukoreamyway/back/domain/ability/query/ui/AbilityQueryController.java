package shop.tukoreamyway.back.domain.ability.query.ui;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shop.tukoreamyway.back.domain.ability.dto.AbilityResponse;
import shop.tukoreamyway.back.domain.ability.dto.AbilitySummary;
import shop.tukoreamyway.back.domain.ability.query.application.AbilityQueryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("abilities")
public class AbilityQueryController {
    private final AbilityQueryService abilityQueryService;

    // staff id를 통한 상세 조회
    @GetMapping
    public ResponseEntity<List<AbilityResponse>> getByStaffId(
            @RequestParam(name = "staff-id") final Long staffId) {
        return ResponseEntity.ok(abilityQueryService.findAllByStaffId(staffId));
    }

    // staff id를 통한 요약 조회
    @GetMapping("summary")
    public ResponseEntity<AbilitySummary> getSummaryByStaffId(
            @RequestParam(name = "staff-id") final Long staffId) {
        return ResponseEntity.ok(abilityQueryService.findSummaryByStaffId(staffId));
    }

    @GetMapping("myability")
    public ResponseEntity<List<AbilityResponse>> getAllMyAbility(
            @RequestParam(name = "team-id") final Long teamId) {
        return ResponseEntity.ok(abilityQueryService.findAllMyAbility(teamId));
    }

    // staff id를 통한 요약 조회
    @GetMapping("myability/summary")
    public ResponseEntity<AbilitySummary> getMyAbilitySummary(
            @RequestParam(name = "team-id") final Long teamId) {
        return ResponseEntity.ok(abilityQueryService.findAllMyAbilitySummary(teamId));
    }
}
