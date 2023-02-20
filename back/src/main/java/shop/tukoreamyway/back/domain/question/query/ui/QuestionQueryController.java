package shop.tukoreamyway.back.domain.question.query.ui;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shop.tukoreamyway.back.domain.question.entity.Question;
import shop.tukoreamyway.back.domain.question.query.application.QuestionQueryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionQueryController {
    private final QuestionQueryService questionQueryService;

    @GetMapping()
    public ResponseEntity<List<Question>> getAllQuestion(
            @RequestParam(required = false) Long memberId) {
        return ResponseEntity.ok(questionQueryService.getAllQuestion(memberId));
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable Long questionId) {
        return ResponseEntity.ok(questionQueryService.getQuestionById(questionId));
    }
}
