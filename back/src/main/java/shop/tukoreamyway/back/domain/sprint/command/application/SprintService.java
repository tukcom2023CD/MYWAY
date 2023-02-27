package shop.tukoreamyway.back.domain.sprint.command.application;

import lombok.RequiredArgsConstructor;

import shop.tukoreamyway.back.domain.project.entity.Project;
import shop.tukoreamyway.back.domain.sprint.entity.Sprint;
import shop.tukoreamyway.back.global.service.CommandService;

import java.time.LocalDate;

@CommandService
@RequiredArgsConstructor
public class SprintService {
    private final SprintRepository sprintRepository;

    public void createInitial(final Project project) {
        if (project.getEndAt() == null) {
            return;
        }
        int round = 1;
        LocalDate datePivot = LocalDate.from(project.getStartAt());
        final LocalDate endDate = LocalDate.from(project.getEndAt());
        final Integer sprintDays = project.getSprintDays();
        while (!getNextDays(datePivot, sprintDays).isAfter(endDate)) {
            sprintRepository.save(
                    new Sprint(
                            project,
                            round,
                            datePivot,
                            getNextDays(datePivot, sprintDays - 1),
                            project.getManager()));
            datePivot = getNextDays(datePivot, sprintDays);
            round++;
        }
        if (!datePivot.isEqual(endDate)) {
            sprintRepository.save(
                    new Sprint(project, round, datePivot, endDate, project.getManager()));
        }
    }

    private LocalDate getNextDays(final LocalDate datePivot,final Integer sprintDays) {
        return datePivot.plusDays(sprintDays);
    }
}
