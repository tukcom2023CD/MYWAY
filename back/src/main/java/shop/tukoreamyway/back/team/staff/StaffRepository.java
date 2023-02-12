package shop.tukoreamyway.back.team.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.tukoreamyway.back.member.domain.Member;
import shop.tukoreamyway.back.team.staff.domain.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByTeamIdAndMember(Long id, Member member);
    List<Staff> findAllByMember(Member member);
    List<Staff> findAllByTeamId(Long teamId);

}
