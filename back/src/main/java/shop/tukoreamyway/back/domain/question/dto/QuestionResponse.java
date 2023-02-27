package shop.tukoreamyway.back.domain.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tukoreamyway.back.domain.staff.dto.StaffSummary;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    private Long id;
    private String title;
    private String content;
    private Long teamId;
    private List<String> tags = new ArrayList<>();
    private StaffSummary writer;
}
