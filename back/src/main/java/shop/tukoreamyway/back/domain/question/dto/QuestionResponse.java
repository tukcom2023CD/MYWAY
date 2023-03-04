package shop.tukoreamyway.back.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuestionResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final Long teamId;
    private final List<String> tags;
    private final StaffSummary writer;
}
