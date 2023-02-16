package shop.tukoreamyway.back.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.domain.staff.entity.Staff;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    private String title;
    private String content;
    private Long teamId;
    private Staff staff;
    private List<String> tags = new ArrayList<>();
}
