package shop.tukoreamyway.back.config.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** jwt토큰을 통한 인가 필터 매 요청시 마다 호출 @Author Hyeonjun Park */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final String accessTokenHeaderTag;
    private final JwtValidator jwtValidator;

    public JwtAuthenticationFilter(
            @Value("${jwt.access-header}") String accessTokenHeaderTag, JwtValidator jwtValidator) {
        this.accessTokenHeaderTag = accessTokenHeaderTag;
        this.jwtValidator = jwtValidator;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Optional<String> token = Optional.ofNullable(extractToken(request.getCookies()));
        token.ifPresent(
                t -> {
                    Authentication authentication = jwtValidator.getAuthentication(t);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                });
        filterChain.doFilter(request, response);
    }

    private String extractToken(Cookie[] cookies) {
        if (cookies == null) {
            return null;
        }

        Optional<Cookie> accessCookie = extractAccessToken(cookies);
        return accessCookie.map(Cookie::getValue).orElse(null);
    }

    private Optional<Cookie> extractAccessToken(Cookie[] cookies) {
        return Arrays.stream(cookies)
                .filter(c -> c.getName().equals(accessTokenHeaderTag))
                .findFirst();
    }
}
