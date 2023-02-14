package shop.tukoreamyway.back.staff.query.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.tukoreamyway.back.staff.domain.Staff;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StaffQueryService {
    private final StaffQueryRepository staffQueryRepository;
    public Staff getEntity(Long id) {
        return staffQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
