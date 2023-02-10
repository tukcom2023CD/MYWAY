package shop.tukoreamyway.back.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class MemberSummary {
    private UUID id;
    private String name;
}
