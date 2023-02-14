package shop.tukoreamyway.back.support.docs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import shop.tukoreamyway.back.config.security.jwt.JwtAuthenticationFilter;
import shop.tukoreamyway.back.config.security.oauth2.LoginUser;
import shop.tukoreamyway.back.support.filter.MockSecurityFilter;

import java.security.Principal;
import java.util.UUID;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@Import(RestDocsConfiguration.class)
@AutoConfigureRestDocs
@WebMvcTest
public abstract class RestDocumentTest {

    @Autowired private ObjectMapper objectMapper;
    protected MockMvc mockMvc;

    protected Principal loginUser =
            new UsernamePasswordAuthenticationToken(
                    new LoginUser(UUID.randomUUID(), null, null), null);
    @MockBean private JwtAuthenticationFilter jwtAuthenticationFilter;
    @MockBean private JpaMetamodelMappingContext jpaMetamodelMappingContext;

    protected String toRequestBody(Object value) throws JsonProcessingException {
        return objectMapper.writeValueAsString(value);
    }

    @BeforeEach
    public void setupMockMvc(
            WebApplicationContext ctx,
            RestDocumentationContextProvider restDocumentationContextProvider) {
        mockMvc =
                MockMvcBuilders.webAppContextSetup(ctx)
                        .apply(
                                documentationConfiguration(restDocumentationContextProvider)
                                        .uris()
                                        .withScheme("http")
                                        .withHost("223.255.205.62")
                                        .withPort(30505))
                        .apply(springSecurity(new MockSecurityFilter()))
                        .addFilter(new CharacterEncodingFilter("UTF-8", true))
                        .alwaysDo(print())
                        .alwaysDo(document("api/v1/"))
                        .build();
    }
}
