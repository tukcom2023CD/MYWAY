package shop.tukoreamyway.back.global;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Basetime {
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
}
