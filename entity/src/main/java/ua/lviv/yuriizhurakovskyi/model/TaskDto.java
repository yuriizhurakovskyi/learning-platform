package ua.lviv.yuriizhurakovskyi.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tsk_id")
    private Integer id;
    @Column(name = "tsk_description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private LessonDto lessonDto;
}
