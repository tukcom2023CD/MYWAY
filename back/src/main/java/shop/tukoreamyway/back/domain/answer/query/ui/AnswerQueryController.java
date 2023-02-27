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
    public ResponseEntity<List<AnswerResponse>> findAllByQuestionId(@RequestParam("question-id") Long questionId) {
        return ResponseEntity.ok(answerQueryService.findAllByQuestionId(questionId));
    }

    @GetMapping("{id}")
    public ResponseEntity<AnswerResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(answerQueryService.findById(id));
    }
}
