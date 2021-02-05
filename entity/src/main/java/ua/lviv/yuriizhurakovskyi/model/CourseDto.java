package ua.lviv.yuriizhurakovskyi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
