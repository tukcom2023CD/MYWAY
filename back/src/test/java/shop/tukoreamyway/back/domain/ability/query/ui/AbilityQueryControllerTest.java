package shop.tukoreamyway.back.domain.ability.query.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;
import shop.tukoreamyway.back.domain.ability.dto.AbilitySummary;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.ability.query.application.AbilityQueryService;
import shop.tukoreamyway.back.support.docs.RestDocumentTest;
import shop.tukoreamyway.back.support.fixture.ability.AbilityResponseFixture;
import shop.tukoreamyway.back.support.fixture.staff.StaffSummaryFixture;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentRequest;
import static shop.tukoreamyway.back.support.docs.ApiDocumentUtils.getDocumentResponse;

@WebMvcTest(AbilityQueryController.class)
@DisplayName("AbilityQueryController에서")
class AbilityQueryControllerTest extends RestDocumentTest {
    @MockBean
    private AbilityQueryService abilityQueryService;

    @Test
    @DisplayName("staffId를 통한 상세조회를 수행하는가")
    void successGetByStaffId() throws Exception {
        //given
        when(abilityQueryService.findAllByStaffId(any())).thenReturn(List.of(
                AbilityResponseFixture.SAMPLE1.toDto(),
                AbilityResponseFixture.SAMPLE2.toDto(),
                AbilityResponseFixture.SAMPLE3.toDto()
        ));
        //when
        ResultActions perform = mockMvc.perform(get("/abilities")
                .param("staff-id", "3"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get ability list by staff id", getDocumentRequest(), getDocumentResponse()));
    }

    @Test
    @DisplayName("staffId를 통한 요약조회를 수행하는가")
    void successGetSummaryByStaffId() throws Exception {
        //given
        when(abilityQueryService.findSummaryByStaffId(any())).thenReturn(new AbilitySummary(StaffSummaryFixture.THOR.toDto(), pointExample()));
        //when
        ResultActions perform = mockMvc.perform(get("/abilities/summary")
                .param("staff-id", "3"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get ability summary by staff id", getDocumentRequest(), getDocumentResponse()));
    }

    private Map<AbilityCategory, Long> pointExample() {
        Map<AbilityCategory, Long> points = new EnumMap<>(AbilityCategory.class);
        points.put(AbilityCategory.COMMUNICATION, 60L);
        points.put(AbilityCategory.CRISIS_RESPONSE, 70L);
        points.put(AbilityCategory.PLANNING, 80L);
        points.put(AbilityCategory.DEVELOPMENT, 60L);
        points.put(AbilityCategory.REFACTORING, 70L);
        return points;
    }

    @Test
    @DisplayName("로그인한 유저를 통한 상세조회를 수행하는가")
    void successGetMyAbility() throws Exception {
        //given
        when(abilityQueryService.findAllMyAbility(any())).thenReturn(List.of(
                AbilityResponseFixture.SAMPLE1.toDto(),
                AbilityResponseFixture.SAMPLE2.toDto(),
                AbilityResponseFixture.SAMPLE3.toDto()
        ));
        //when
        ResultActions perform = mockMvc.perform(get("/abilities/myability")
                .param("team-id", "3"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get my ability list", getDocumentRequest(), getDocumentResponse()));

    }

    @Test
    @DisplayName("로그인한 유저의 요약조회를 수행하는가")
    void successGetMyAbilitySummary() throws Exception {
        //given
        when(abilityQueryService.findAllMyAbilitySummary(any())).thenReturn(new AbilitySummary(StaffSummaryFixture.THOR.toDto(), pointExample()));
        //when
        ResultActions perform = mockMvc.perform(get("/abilities/myability/summary")
                .param("team-id", "3"));
        // then
        perform.andExpect(status().isOk());

        // docs
        perform.andDo(print())
                .andDo(document("get my ability summary", getDocumentRequest(), getDocumentResponse()));
    }

}