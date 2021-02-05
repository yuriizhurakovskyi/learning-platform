package ua.lviv.yuriizhurakovskyi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lesson")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class LessonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ls_id")
    private Integer id;
    @Column(name = "ls_lecture_topic")
    private String lectureTopic;
    @Column(name = "ls_description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseDto courseDto;
    @OneToMany(mappedBy = "task",
            cascade = CascadeType.ALL)
    private Set<TaskDto> taskDtos;
}
