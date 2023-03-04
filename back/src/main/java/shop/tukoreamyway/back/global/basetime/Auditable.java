package shop.tukoreamyway.back.global.basetime;

import org.hibernate.annotations.Where;

@Where(clause = "deleted_at is null")
public interface Auditable {
    BaseTime getBaseTime();

    void setBaseTime(BaseTime baseTime);
}
