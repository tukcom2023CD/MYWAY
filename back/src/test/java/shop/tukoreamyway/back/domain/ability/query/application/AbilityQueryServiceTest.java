package shop.tukoreamyway.back.domain.ability.query.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import shop.tukoreamyway.back.domain.ability.entity.AbilityCategory;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
class AbilityQueryServiceTest {

    @Nested
    @DisplayName("enum map 학습 테스트")
    class StudyEnumMap {
        @Test
        @DisplayName("enummap 초기값이 null로 들어가는가")
        void checkEnumMapDefaultValue() throws Exception {
            // given
            Map<AbilityCategory, Integer> maps = new EnumMap<>(AbilityCategory.class);
            // when
            Integer value = maps.get(AbilityCategory.CRISIS_RESPONSE);
            // then
            assertThat(value).isNull();
        }
    }

}
