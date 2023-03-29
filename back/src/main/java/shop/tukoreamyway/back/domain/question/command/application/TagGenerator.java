package shop.tukoreamyway.back.domain.question.command.application;

import lombok.RequiredArgsConstructor;
import shop.tukoreamyway.back.domain.question.entity.Tag;
import shop.tukoreamyway.back.global.service.CommandService;

import java.util.List;

@CommandService
@RequiredArgsConstructor
public class TagGenerator {
    private final TagRepository tagRepository;

    public List<Tag> generate(final List<String> values) {
        return values.stream().map(this::saveIfNone).toList();
    }

    private Tag saveIfNone(final String value) {
        return tagRepository.findByName(value)
                .orElseGet(() -> tagRepository.save(new Tag(value)));
    }

}
