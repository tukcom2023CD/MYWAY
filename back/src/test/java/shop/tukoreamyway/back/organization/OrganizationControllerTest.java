package shop.tukoreamyway.back.organization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.member.dto.MemberSummary;
import shop.tukoreamyway.back.organization.domain.IndustryGroup;
import shop.tukoreamyway.back.organization.dto.OrganizationRequest;
import shop.tukoreamyway.back.organization.dto.OrganizationResponse;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

@WebMvcTest(OrganizationController.class)
@DisplayName("OrganizationController에서")
class OrganizationControllerTest extends RestDocumentTest {

    @MockBean
    private OrganizationService organizationService;

    @Test
    @DisplayName("저장을 수행하는가")
    void successSave() throws Exception {
        //given
        OrganizationRequest requestBody = new OrganizationRequest("순양 그룹", IndustryGroup.IT);
        OrganizationResponse expected = new OrganizationResponse(1L, "순양 그룹", new MemberSummary(UUID.randomUUID(), "진양철"), IndustryGroup.IT.getName());
        when(organizationService.create(any())).thenReturn(expected);
        //when
        ResultActions perform = mockMvc.perform(post("/organizations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toRequestBody(requestBody)));

        // then
        perform.andExpect(status().isCreated());

        // docs
        perform.andDo(print())
                .andDo(document("create organization", getDocumentRequest(), getDocumentResponse()));

    }
}