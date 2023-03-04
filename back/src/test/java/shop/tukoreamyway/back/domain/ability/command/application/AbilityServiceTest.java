package shop.tukoreamyway.back.domain.ability.command.application;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static shop.tukoreamyway.back.support.database.SampleDataLongTypeId.STAFF1;
import static shop.tukoreamyway.back.support.database.SampleDataLongTypeId.STAFF4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.tukoreamyway.back.domain.ability.dto.AbilityRequest;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;
import shop.tukoreamyway.back.domain.ability.entity.GrantLocation;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.global.service.EntityLoader;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;
import shop.tukoreamyway.back.support.database.UseSampleData;

import java.time.LocalDateTime;

@EnableDataBaseTest
@DisplayName("abilityService에서")
class AbilityServiceTest extends LoginTest {
    @Autowired private AbilityService abilityService;
    @Autowired private EntityLoader<Staff, Long> staffLoader;

    @Test
    @DisplayName("생성을 수행하는가")
    @UseSampleData
    void successCreate() throws Exception {
        // given
        AbilityRequest req =
                new AbilityRequest(
                        AbilityCategory.DEVELOPMENT,
                        STAFF4.getId(),
                        20L,
                        LocalDateTime.now(),
                        GrantLocation.DO_TASK,
                        null);
        // when
        IdResponse<Long> result = abilityService.create(req);
        Staff entity = staffLoader.getEntity(STAFF1.getId());
        // then
        assertThat(result.getId()).isNotNull();
    }
}
