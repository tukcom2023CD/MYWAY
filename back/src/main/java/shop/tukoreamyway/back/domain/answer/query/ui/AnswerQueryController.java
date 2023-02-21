package shop.tukoreamyway.back.domain.answer.query.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.domain.answer.dto.AnswerResponse;
import shop.tukoreamyway.back.domain.answer.query.application.AnswerQueryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("answers")
public class AnswerQueryController {
    private final AnswerQueryService answerQueryService;

    @GetMapping
    public ResponseEntity<List<AnswerResponse>> getAllAnswers(
            @RequestParam(required = false) Long questionId) {
        return ResponseEntity.ok(answerQueryService.findAllAnswers(questionId));
    }

    @GetMapping("{answerId}")
    public ResponseEntity<AnswerResponse> getAnswerById(
            @PathVariable Long answerId) {
        return ResponseEntity.ok(answerQueryService.findAnswerById(answerId));
    }
}
