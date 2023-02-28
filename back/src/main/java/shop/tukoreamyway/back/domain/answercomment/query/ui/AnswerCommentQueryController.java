package shop.tukoreamyway.back.domain.answercomment.query.ui;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentResponse;
import shop.tukoreamyway.back.domain.answercomment.query.application.AnswerCommentQueryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("answer-comments")
public class AnswerCommentQueryController {

    private final AnswerCommentQueryService answerCommentQueryService;

    @GetMapping
    public ResponseEntity<List<AnswerCommentResponse>> findAllByAnswerId(
            @RequestParam final Long answerId) {
        return ResponseEntity.ok(answerCommentQueryService.findAllByAnswerId(answerId));
    }

    @GetMapping("{id}")
    public ResponseEntity<AnswerCommentResponse> findAnswerCommentById(@PathVariable final Long id) {
        return ResponseEntity.ok(answerCommentQueryService.findById(id));
    }
}
