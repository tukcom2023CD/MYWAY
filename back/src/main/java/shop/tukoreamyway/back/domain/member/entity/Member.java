package shop.tukoreamyway.back.domain.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String nickname;

  @Embedded MemberDetail memberDetail = new MemberDetail();

  @Embedded MemberPrivacy memberPrivacy = new MemberPrivacy();


  @Builder
  public Member(String name, String nickname, String email) {
    this.name = name;
    this.nickname = nickname;
    memberDetail.setEmail(email);
  }
}
