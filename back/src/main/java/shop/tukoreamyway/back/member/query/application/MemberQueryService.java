package shop.tukoreamyway.back.member.query.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.tukoreamyway.back.member.domain.Member;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberQueryRepository memberQueryRepository;

    public Member getEntity(UUID id) {
        return memberQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
