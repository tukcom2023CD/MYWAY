package shop.tukoreamyway.back.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class MemberSummary {
    private final UUID id;
    private final String name;
}
