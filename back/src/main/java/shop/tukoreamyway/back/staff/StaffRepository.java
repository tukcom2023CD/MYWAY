package shop.tukoreamyway.back.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.staff.domain.Staff;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    List<Staff> findAllByTeamId(Long id);
    List<Staff> findAllByMember(Member member);
}
