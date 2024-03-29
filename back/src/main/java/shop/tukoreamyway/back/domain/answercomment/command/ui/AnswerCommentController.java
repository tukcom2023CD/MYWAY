package shop.tukoreamyway.back.domain.answercomment.command.ui;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shop.tukoreamyway.back.domain.answercomment.command.application.AnswerCommentService;
import shop.tukoreamyway.back.domain.answercomment.dto.AnswerCommentRequest;
import shop.tukoreamyway.back.domain.answercomment.dto.UpdateAnswerCommentRequest;
import shop.tukoreamyway.back.global.IdResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("answer-comments")
public class AnswerCommentController {
    private final AnswerCommentService answerCommentService;

    @PostMapping
    public ResponseEntity<IdResponse<Long>> create(
            @RequestBody @Valid final AnswerCommentRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(answerCommentService.create(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<IdResponse<Long>> update(
            @RequestBody @Valid final UpdateAnswerCommentRequest dto, @PathVariable final Long id) {
        answerCommentService.update(id, dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<IdResponse<Long>> deleteById(@PathVariable Long id) {
        answerCommentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
