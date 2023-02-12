package shop.tukoreamyway.back.staff;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.tukoreamyway.back.staff.domain.Staff;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;

    public Staff getEntity(Long id) {
        return staffRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
