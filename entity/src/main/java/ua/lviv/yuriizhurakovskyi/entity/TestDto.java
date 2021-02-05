package ua.lviv.yuriizhurakovskyi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "test")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class TestDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
