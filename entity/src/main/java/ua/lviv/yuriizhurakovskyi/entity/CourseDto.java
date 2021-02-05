package ua.lviv.yuriizhurakovskyi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class CourseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cs_id")
    private Integer id;
    @Column(name = "cs_name")
    private String name;
    @Column(name = "cs_level")
    private Level level;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private UserDto addedBy;
    @OneToMany(mappedBy = "lesson",
            cascade = CascadeType.ALL)
    private Set<LessonDto> lessonDtos;
}
