package shop.tukoreamyway.back.global;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class Basetime {
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;
}
