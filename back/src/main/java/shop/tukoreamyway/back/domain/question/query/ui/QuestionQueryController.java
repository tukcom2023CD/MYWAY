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
    public ResponseEntity<List<QuestionResponse>> getAllByWriterId(
            @RequestParam("writer-id") final Long writerId) {
        return ResponseEntity.ok(questionQueryService.findAllByWriterId(writerId));
    }

    @GetMapping("{id}")
    public ResponseEntity<QuestionResponse> getQuestionById(@PathVariable final Long id) {
        return ResponseEntity.ok(questionQueryService.findById(id));
    }
}
