package shop.tukoreamyway.back.domain.answercomment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerCommentRequest {
    private String content;
    private Long answerId;
}
