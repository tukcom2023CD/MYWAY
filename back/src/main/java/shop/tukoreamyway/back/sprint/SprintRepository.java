package shop.tukoreamyway.back.sprint;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint, Long> {
    List<Sprint> findAllByProjectId(Long projectId);
}
