package ua.lviv.yuriizhurakovskyi.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "test_question")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestQuestionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tq_id")
    private Integer id;
    @Column(name = "tq_question")
    private String question;
    @Column(name = "tq_answer")
    private String answer;
    @ManyToOne
    @JoinColumn(name = "tst_id")
    private TestDto testDto;
}
