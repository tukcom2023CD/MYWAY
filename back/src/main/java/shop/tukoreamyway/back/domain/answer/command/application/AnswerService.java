package shop.tukoreamyway.back.domain.answer.command.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.answer.query.application.AnswerQueryRepository;
import shop.tukoreamyway.back.global.CommandService;

@CommandService
@RequiredArgsConstructor
public class AnswerService {

   private final AnswerRepository memberRepository;
   private final AnswerQueryRepository memberQueryRepository;
}
