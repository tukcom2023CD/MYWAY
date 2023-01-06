package shop.tukoreamyway.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BackApplication {
  public static void main(String[] args) {
    SpringApplication.run(BackApplication.class, args);
  }
}
