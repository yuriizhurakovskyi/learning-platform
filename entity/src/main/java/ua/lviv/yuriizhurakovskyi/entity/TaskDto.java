package ua.lviv.yuriizhurakovskyi.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class TaskDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tsk_id")
    private Integer id;
    @Column(name = "tsk_description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private LessonDto lessonDto;
}
