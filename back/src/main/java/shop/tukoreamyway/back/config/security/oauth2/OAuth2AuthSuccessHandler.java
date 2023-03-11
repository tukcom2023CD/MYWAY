package shop.tukoreamyway.back.config.security.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import shop.tukoreamyway.back.config.security.jwt.JwtSetupService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OAuth2 사용지 인증 성공시 진행하는 Handler
 *
 * @author Hyeonjun Park
 */
@Component
@RequiredArgsConstructor
public class OAuth2AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtSetupService jwtSetupService;

    @Value("${client.url}")
    private String clientUrl;

    @Value("${client.endpoint}")
    private String endpoint;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        jwtSetupService.addJwtTokensInCookie(response, loginUser);
        getRedirectStrategy().sendRedirect(request, response, clientUrl + "/" + endpoint);
    }
}
