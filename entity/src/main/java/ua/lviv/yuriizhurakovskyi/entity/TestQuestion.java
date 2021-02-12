package ua.lviv.yuriizhurakovskyi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "test_question", schema = "learning_platform")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tq_id")
    private Long id;
    @Column(name = "tq_question")
    private String question;
    @Column(name = "tq_answer")
    private String answer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tq_test_id")
    private Test test;
}
