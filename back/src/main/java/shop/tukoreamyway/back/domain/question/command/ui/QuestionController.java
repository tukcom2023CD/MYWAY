package shop.tukoreamyway.back.domain.question.command.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.tukoreamyway.back.domain.question.command.application.QuestionService;
import shop.tukoreamyway.back.domain.question.dto.DeleteQuestionRequest;
import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
import shop.tukoreamyway.back.domain.question.dto.UpdateQuestionRequest;
import shop.tukoreamyway.back.global.IdResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("questions")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<IdResponse<Long>> create(@RequestBody @Valid QuestionRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.create(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<IdResponse<Long>> update(
            @RequestBody @Valid UpdateQuestionRequest dto, @PathVariable Long id) {
        questionService.update(id, dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<IdResponse<Long>> deleteById(
            @RequestBody @Valid DeleteQuestionRequest dto, @PathVariable Long id) {
        questionService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
