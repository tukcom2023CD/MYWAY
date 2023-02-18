package shop.tukoreamyway.back.config.security.oauth2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import shop.tukoreamyway.back.config.security.jwt.JwtSetupService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * OAuth2 사용지 인증 성공시 진행하는 Handler
 *
 * @author Hyeonjun Park
 */
@Component
public class OAuth2AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtSetupService jwtSetupService;

    private final String redirectUrl;

    public OAuth2AuthSuccessHandler(
            JwtSetupService jwtSetupService, @Value("${client.url}") String redirectUrl) {
        this.jwtSetupService = jwtSetupService;
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        jwtSetupService.addJwtTokensInCookie(response, loginUser);
        response.sendRedirect(redirectUrl);
    }
}
