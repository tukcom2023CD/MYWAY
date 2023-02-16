package shop.tukoreamyway.back.domain.question.command.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.tukoreamyway.back.domain.question.command.application.QuestionService;
import shop.tukoreamyway.back.domain.question.dto.QuestionRequest;
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
}
