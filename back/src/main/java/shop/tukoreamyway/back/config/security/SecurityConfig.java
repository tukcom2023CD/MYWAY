package shop.tukoreamyway.back.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(requests -> requests.antMatchers("/**").permitAll())
        // .formLogin().disable()
        .csrf()
        .disable()
        .build();
  }
}
