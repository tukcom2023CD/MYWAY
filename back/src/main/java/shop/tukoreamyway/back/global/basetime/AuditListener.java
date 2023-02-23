package shop.tukoreamyway.back.global.basetime;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class AuditListener {
    @PrePersist
    public void setCreatedAt(Auditable auditable) {
        BaseTime baseTime = Optional.ofNullable(auditable.getBaseTime()).orElse(new BaseTime());
        baseTime.setCreatedAt(LocalDateTime.now());
        auditable.setBaseTime(baseTime);
    }

    @PreUpdate
    public void setUpdatedAt(Auditable auditable) {
        auditable.getBaseTime().setUpdatedAt(LocalDateTime.now());
    }

    @PreRemove
    public void setDeleteAt(Auditable auditable) {
        auditable.getBaseTime().setDeletedAt(LocalDateTime.now());
    }
}
