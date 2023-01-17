package shop.tukoreamyway.back.domain.member.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Getter
@Setter
@Embeddable
public class MemberDetail {
    private String email;

    @Lob private String introduction;
}
