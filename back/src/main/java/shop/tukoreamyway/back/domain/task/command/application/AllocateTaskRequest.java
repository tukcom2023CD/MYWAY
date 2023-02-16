package shop.tukoreamyway.back.domain.task.command.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AllocateTaskRequest {
    private Long staffId;
}
