package shop.tukoreamyway.back.domain.question.command.application;

import static org.assertj.core.api.Assertions.assertThat;

import static shop.tukoreamyway.back.support.database.SampleDataLongTypeId.TEAM1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryRepository;
import shop.tukoreamyway.back.domain.staff.command.application.StaffRepository;
import shop.tukoreamyway.back.domain.staff.entity.Staff;
import shop.tukoreamyway.back.domain.team.entity.Team;
import shop.tukoreamyway.back.domain.team.query.application.TeamQueryRepository;
import shop.tukoreamyway.back.global.IdResponse;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;
import shop.tukoreamyway.back.support.database.UseSampleData;

import java.util.List;

@EnableDataBaseTest
@DisplayName("QuestionService에서")
class QuestionServiceTest extends LoginTest {
    @Autowired private QuestionService questionService;
    @Autowired private QuestionQueryRepository questionQueryRepository;
    @Autowired private StaffRepository staffRepository;
    @Autowired private TeamQueryRepository teamRepository;

    @Nested
    @DisplayName("create 호출 시")
    class CallCreate {
        @Test
        @DisplayName("저장을 수행하는가")
        @UseSampleData
        void successSave() throws Exception {
            // given
            List<String> tags = List.of("커뮤니케이션", "개발");
            Team team = teamRepository.findById(TEAM1.getId()).orElseThrow();
            Staff staff = staffRepository.save(new Staff(team, loginUser));
            QuestionRequest req = new QuestionRequest("제목", "내용", TEAM1.getId(), tags);
            // when
            IdResponse<Long> longIdResponse = questionService.create(req);

            // then
            assertThat(longIdResponse).isNotNull();
            Question question = questionQueryRepository.findById(longIdResponse.getId()).get();
            assertThat(question.getTeamId()).isEqualTo(TEAM1.getId());
            assertThat(question.getTitle()).isEqualTo(req.getTitle());
            assertThat(question.getWriter()).isEqualTo(staff);
            assertThat(question.getContent()).isEqualTo(req.getContent());
            assertThat(question.getTags()).isEmpty(); // TODO tags 불러오기
        }
    }
}
