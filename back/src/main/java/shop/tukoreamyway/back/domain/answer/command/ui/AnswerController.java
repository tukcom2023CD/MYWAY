package shop.tukoreamyway.back.domain.answer.command.ui;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.tukoreamyway.back.domain.answer.command.application.AnswerService;
import shop.tukoreamyway.back.domain.answer.dto.AnswerRequest;
import shop.tukoreamyway.back.global.IdResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("answers")
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping
    public ResponseEntity<IdResponse<Long>> create(@RequestBody @Valid AnswerRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(answerService.create(dto));
    }
}
