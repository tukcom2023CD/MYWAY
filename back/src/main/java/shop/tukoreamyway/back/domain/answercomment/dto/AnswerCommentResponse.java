package shop.tukoreamyway.back.domain.answercomment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerCommentResponse {
    private Long id;
    private String content;
    private Long answerId;
    private StaffSummary writer;
}
