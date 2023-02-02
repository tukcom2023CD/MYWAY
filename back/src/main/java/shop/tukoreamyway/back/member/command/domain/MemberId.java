package shop.tukoreamyway.back.member.command.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
@Getter
@Embeddable
public class MemberId implements Serializable {

    @Column(name = "member_id", columnDefinition = "BINARY(16)")
    private UUID id;

    public MemberId() {
        this.id = UUID.randomUUID();
    }

    public MemberId(UUID id) {
        this.id = id;
    }
    public MemberId(String id) {
        this.id = UUID.fromString(id);
    }
}
