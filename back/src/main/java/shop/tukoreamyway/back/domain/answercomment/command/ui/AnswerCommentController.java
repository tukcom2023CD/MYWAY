package shop.tukoreamyway.back.domain.answercomment.command.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.tukoreamyway.back.domain.answercomment.command.application.AnswerCommentService;
import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentRequest;
import shop.tukoreamyway.back.global.IdResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("answer-comments")
public class AnswerCommentController {
    private final AnswerCommentService answerCommentService;

    @PostMapping
    public ResponseEntity<IdResponse<Long>> create(@RequestBody @Valid AnswerCommentRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(answerCommentService.create(dto));
    }

    @PostMapping
    public ResponseEntity<IdResponse<Long>> update(@RequestBody @Valid AnswerCommentRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(answerCommentService.create(dto));
    }
}
