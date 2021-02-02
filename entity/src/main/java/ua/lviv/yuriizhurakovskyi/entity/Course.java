package ua.lviv.yuriizhurakovskyi.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
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
    private User addedBy;
    @OneToMany(mappedBy = "lesson",
            cascade = CascadeType.ALL)
    private Set<Lesson> lessons;

    public Course() {
    }

    public Course(Integer id, String name, Level level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public Course(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name) && level == course.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
