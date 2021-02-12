package ua.lviv.yuriizhurakovskyi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "course", schema = "learning_platform")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cs_id")
    private Integer id;
    @Column(name = "cs_name")
    private String name;
    @Column(name = "cs_level")
    @Enumerated(EnumType.STRING)
    private Level level;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cs_added_by")
    private User addedBy;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<Lesson> lessons;
}
