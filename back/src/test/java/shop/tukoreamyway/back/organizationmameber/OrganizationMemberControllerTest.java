package shop.tukoreamyway.back.organization.organizationmameber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.util.Set;
import java.util.UUID;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

@WebMvcTest(OrganizationMemberController.class)
@DisplayName("OrganizationMemberController에서")
class OrganizationMemberControllerTest extends RestDocumentTest {
    @MockBean
    private OrganizationMemberService organizationMemberService;

    @Test
    @DisplayName("invite를 수행하는가")
    void successSave() throws Exception {
        //given
        InviteOrganizationRequest requestBody = new InviteOrganizationRequest(5L, Set.of(UUID.randomUUID(), UUID.randomUUID()));
        //when
        ResultActions perform = mockMvc.perform(post("/organization-members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toRequestBody(requestBody)));
        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("create organization", getDocumentRequest(), getDocumentResponse()));
    }
}