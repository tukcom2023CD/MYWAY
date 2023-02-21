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
    public ResponseEntity<List<AnswerCommentResponse>> findAllAnswerComments (
            @RequestParam(required = false) Long memberId) {
        return ResponseEntity.ok(answerCommentQueryService.findAllAnswerComments(memberId));
    }

    @GetMapping("{answer-commentsId}")
    public ResponseEntity<AnswerCommentResponse> findAnswerCommentById(
            @PathVariable Long questionId) {
        return ResponseEntity.ok(answerCommentQueryService.findAnswerCommentById(questionId));
    }
}
