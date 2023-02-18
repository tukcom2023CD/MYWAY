package shop.tukoreamyway.back.domain.staff.command.application;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByTeamIdAndMember(Long id, Member member);

    List<Staff> findAllByMember(Member member);

    List<Staff> findAllByTeamId(Long teamId);
}
