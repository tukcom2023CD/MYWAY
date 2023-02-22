package shop.tukoreamyway.back.config.security;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import shop.tukoreamyway.back.config.security.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuthUserService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationSuccessHandler successHandler;
    @Value("${client.url}")
    private String clientUrl;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @author Hyeonjun Park
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                        requests ->
                                requests.antMatchers("auth/login/**")
                                        .permitAll()
                                        .antMatchers("api/test/**")
                                        .authenticated())
                // .formLogin().disable()
                .oauth2Login(setOAuth2Config())
                .sessionManagement(setSessionManagementConfig())
                .addFilterBefore(
                        jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf()
                .disable()
                .build();
    }

    /**
     * Session management 설정 JWT 방식으로 인증을 진행하기에 SessionCreation 정책을 STATELESS로 변경
     *
     * @author Hyeonjun Park
     */
    private Customizer<SessionManagementConfigurer<HttpSecurity>> setSessionManagementConfig() {
        return s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * OAuth2 설정 꼭 chain 순서 변경 안하더라도, endpoint.userService 다음에 successHandler 수행
     *
     * @author Hyeonjun Park
     */
    private Customizer<OAuth2LoginConfigurer<HttpSecurity>> setOAuth2Config() {
        return o ->
                o.authorizationEndpoint(auth -> auth.baseUri("/auth/login"))
                        .userInfoEndpoint(e -> e.userService(oAuthUserService))
                        .successHandler(successHandler);
    }

    /**
     * Cors 설정
     *
     * @author Hyeonjun Park
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin(clientUrl);
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
