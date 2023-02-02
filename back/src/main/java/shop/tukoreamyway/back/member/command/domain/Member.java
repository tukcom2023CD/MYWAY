package shop.tukoreamyway.back.member.command.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Getter
    @EmbeddedId private MemberId id;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Role> role = new ArrayList<>(List.of(Role.ROLE_USER));

    @Embedded
    private OAuth2Info oAuth2Info;

    public List<SimpleGrantedAuthority> getRole() {
        return role.stream().map(Role::name).map(SimpleGrantedAuthority::new).toList();
    }

    @Builder
    public Member(MemberId id, OAuth2Info oAuth2Info) {
        this.id = id;
        this.oAuth2Info = oAuth2Info;
    }
}
