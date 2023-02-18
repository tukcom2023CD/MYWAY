package shop.tukoreamyway.back.domain.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequest {
    @NotBlank private String name;
    @NotNull private LocalDateTime startAt;
    private LocalDateTime endAt;
    @NotNull private Long teamId;
    private Integer sprintDays = 7;
    @NotNull private Long managerId;
}
