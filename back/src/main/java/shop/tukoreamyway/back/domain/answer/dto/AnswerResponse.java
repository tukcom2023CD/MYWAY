package shop.tukoreamyway.back.domain.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponse {
    private Long id;
    private String content;
    private Long questionId;
    private StaffSummary writer;
}
