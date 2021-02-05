package ua.lviv.yuriizhurakovskyi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "test")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tst_id")
    private Integer id;
    @Column(name = "tst_name")
    private String name;
    @Column(name = "tst_count_of_question")
    private Integer countOfQuestions;
    @Column(name = "tst_level")
    private Level level;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private UserDto addedBy;
    @OneToMany(mappedBy = "test_question")
    private Set<TestQuestionDto> testQuestionDtos;
}
