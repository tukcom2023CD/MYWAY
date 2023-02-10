package shop.tukoreamyway.back.organization;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.organization.dto.OrganizationRequest;
import shop.tukoreamyway.back.organization.dto.OrganizationResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationResponse> save(@RequestBody @Valid OrganizationRequest dto) {
        OrganizationResponse result = organizationService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
