package shop.tukoreamyway.back.domain.answercomment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;

@Getter
@Builder
@AllArgsConstructor
public class AnswerCommentResponse {
    private final Long id;
    private final String content;
    private final Long answerId;
    private final StaffSummary writer;
}
