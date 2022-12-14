package shop.tukoreamyway.back.domain.authaccount.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.tukoreamyway.back.domain.authaccount.entity.AuthAccount;

@Repository
public interface AuthAccountRepository extends JpaRepository<AuthAccount, UUID> {
  Optional<AuthAccount> findByAccountId(String accountId);

  boolean existsByAccountId(String accountId);
}
