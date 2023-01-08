package shop.tukoreamyway.back.domain.member.entity;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class MemberDetail {
  private String email;

  @Lob private String introduction;
}
