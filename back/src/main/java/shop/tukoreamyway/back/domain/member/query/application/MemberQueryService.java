package shop.tukoreamyway.back.domain.member.query.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.member.entity.Member;
import shop.tukoreamyway.back.global.QueryService;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

@QueryService
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberQueryRepository memberQueryRepository;

    public Member getEntity(final UUID id) {
        return memberQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
