package shop.tukoreamyway.back.domain.answer.entity;

import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Answer {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String writer;

    public void SetTitle(String title) {
        this.title = title;
    }

    public void SetContent(String content) {
        this.content = content;
    }

    public void SetWriter(String writer) {
        this.writer = writer;
    }

    public Answer() {

    }

}
