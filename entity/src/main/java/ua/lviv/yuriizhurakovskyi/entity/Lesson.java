package ua.lviv.yuriizhurakovskyi.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lesson")
public class Lesson {
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
    private Course course;
    @OneToMany(mappedBy = "task",
            cascade = CascadeType.ALL)
    private Set<Task> tasks;

    public Lesson() {
    }

    public Lesson(String lectureTopic, String description) {
        this.lectureTopic = lectureTopic;
        this.description = description;
    }

    public Lesson(Integer id, String lectureTopic, String description) {
        this.id = id;
        this.lectureTopic = lectureTopic;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLectureTopic() {
        return lectureTopic;
    }

    public void setLectureTopic(String lectureTopic) {
        this.lectureTopic = lectureTopic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lectureTopic='" + lectureTopic + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
