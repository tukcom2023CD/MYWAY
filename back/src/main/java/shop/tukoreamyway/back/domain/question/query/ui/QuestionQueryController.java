package shop.tukoreamyway.back.domain.question.query.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.domain.question.dto.QuestionResponse;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("questions")
public class QuestionQueryController {
    private final QuestionQueryService questionQueryService;

    @GetMapping
    public ResponseEntity<List<QuestionResponse>> getAllQuestions(
            @RequestParam(required = false) Long memberId) {
        return ResponseEntity.ok(questionQueryService.findAllQuestions(memberId));
    }

    @GetMapping("{questionId}")
    public ResponseEntity<QuestionResponse> getQuestionById(
            @PathVariable Long questionId) {
        return ResponseEntity.ok(questionQueryService.findQuestionById(questionId));
    }
}
