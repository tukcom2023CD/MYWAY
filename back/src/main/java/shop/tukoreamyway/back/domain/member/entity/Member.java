package shop.tukoreamyway.back.domain.member.entity;

import lombok.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import shop.tukoreamyway.back.global.basetime.AuditListener;
import shop.tukoreamyway.back.global.basetime.Auditable;
import shop.tukoreamyway.back.global.basetime.BaseTime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditListener.class)
public class Member implements Auditable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Setter private String name;
    @Setter private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Role> role = new ArrayList<>(List.of(Role.ROLE_USER));

    @Embedded private OAuth2Info oAuth2Info;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    public List<SimpleGrantedAuthority> getRole() {
        return role.stream().map(Role::name).map(SimpleGrantedAuthority::new).toList();
    }

    @Builder
    public Member(OAuth2Info oAuth2Info) {
        this.oAuth2Info = oAuth2Info;
    }
}
