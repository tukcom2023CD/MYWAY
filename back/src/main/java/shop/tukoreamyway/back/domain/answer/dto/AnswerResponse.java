package shop.tukoreamyway.back.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;

@Getter
@Builder
@AllArgsConstructor
public class AnswerResponse {
    private final Long id;
    private final String content;
    private final Long questionId;
    private final StaffSummary writer;
}
