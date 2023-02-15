package shop.tukoreamyway.back.domain.staff.query.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.tukoreamyway.back.domain.staff.dto.StaffResponse;
import shop.tukoreamyway.back.domain.staff.query.application.StaffQueryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("staffs")
public class StaffQueryController {
    private final StaffQueryService staffQueryService;

    @GetMapping(value = "apply", params = "group-id")
    public ResponseEntity<List<StaffResponse>> getApply(@RequestParam(name = "group-id") Long groupId) {
        return ResponseEntity.ok(staffQueryService.findAllApplyByTeamId(groupId));
    }

    @GetMapping("invite")
    public ResponseEntity<List<StaffResponse>> getInvite() {
        return ResponseEntity.ok(staffQueryService.findAllInvite());
    }
}
