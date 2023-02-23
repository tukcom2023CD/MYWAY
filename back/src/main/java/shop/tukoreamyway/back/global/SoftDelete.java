package shop.tukoreamyway.back.global;

import org.hibernate.annotations.Where;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@Where(clause = "deleted_at is null")
public @interface SoftDelete {
}
