package shop.tukoreamyway.back.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    private Long id;
    private Long questionId;
    private String title;
    private Long writerId;
    private String content;
    private Long teamId;
    private List<String> tags = new ArrayList<>();
}
