package shop.tukoreamyway.back.organizationmameber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.member.dto.MemberSummary;
import shop.tukoreamyway.back.organization.domain.IndustryGroup;
import shop.tukoreamyway.back.organization.dto.OrganizationSummary;
import shop.tukoreamyway.back.organizationmameber.dto.InviteOrganizationRequest;
import shop.tukoreamyway.back.organizationmameber.dto.InviteResponse;
import shop.tukoreamyway.back.organizationmameber.dto.OrganizationMemberResponse;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
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
                .andDo(document("invite organization", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("로그인 한 유저의 초대 정보를 가져오는가")
    void successGetInvites() throws Exception {
        //given
        List<InviteResponse> expected = List.of(
                new InviteResponse(1L, new OrganizationSummary(2L, "네이버", IndustryGroup.IT.getName())),
                new InviteResponse(2L, new OrganizationSummary(4L, "카카오", IndustryGroup.IT.getName())),
                new InviteResponse(3L, new OrganizationSummary(6L, "라인", IndustryGroup.IT.getName())),
                new InviteResponse(4L, new OrganizationSummary(8L, "배민", IndustryGroup.IT.getName()))
        );
        when(organizationMemberService.findLoginUserInvites()).thenReturn(expected);
        //when
        ResultActions perform = mockMvc.perform(get("/organization-members/auth-user"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get invite list", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("그룹에 속한 맴버들을 가져오는가")
    void successGetByOrganizationId() throws Exception {
        //given
        OrganizationMemberResponse expected = new OrganizationMemberResponse
                (new OrganizationSummary(5L, "카카오", IndustryGroup.IT.getName()),
                        List.of(
                                new MemberSummary(UUID.randomUUID(), "홍길동"),
                                new MemberSummary(UUID.randomUUID(), "춘향"),
                                new MemberSummary(UUID.randomUUID(), "라이언")
                        )
                );
        when(organizationMemberService.findByOrganizationId(any())).thenReturn(expected);
        //when
        ResultActions perform = mockMvc.perform(get("/organization-members")
                .param("organization-id", "5"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get organization member list", getDocumentRequest(), getDocumentResponse()));

    }

}