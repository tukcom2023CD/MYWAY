package shop.tukoreamyway.back.domain.project.command.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import shop.tukoreamyway.back.domain.project.dto.ProjectRequest;
import shop.tukoreamyway.back.domain.project.dto.ProjectResponse;
import shop.tukoreamyway.back.support.LoginTest;
import shop.tukoreamyway.back.support.database.EnableDataBaseTest;
import shop.tukoreamyway.back.support.database.UseSampleData;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static shop.tukoreamyway.back.support.database.SampleDataLongTypeId.STAFF1;
import static shop.tukoreamyway.back.support.database.SampleDataLongTypeId.TEAM1;

@EnableDataBaseTest
@DisplayName("ProjectService 에서")
class ProjectServiceTest extends LoginTest {
    @Autowired
    private ProjectService projectService;

    @Test
    @DisplayName("생성을 수행하는가")
    @UseSampleData
    void successCreate() throws Exception {
        //given
        ProjectRequest req = new ProjectRequest("프로젝트1", LocalDateTime.now(), null, TEAM1.getId(), 7, STAFF1.getId());
        //when
        ProjectResponse result = projectService.create(req);
        //then
        assertThat(result.getId()).isNotNull();
        assertThat(result.getName()).isEqualTo(req.getName());
        assertThat(result.getStartAt()).isEqualTo(req.getStartAt());
        assertThat(result.getSprintDays()).isEqualTo(req.getSprintDays());
        assertThat(result.getTeam().getId()).isEqualTo(TEAM1.getId());
        assertThat(result.getManager().getId()).isEqualTo(STAFF1.getId());
    }
}