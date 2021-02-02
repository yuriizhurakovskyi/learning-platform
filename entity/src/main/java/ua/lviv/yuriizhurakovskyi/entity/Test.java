package ua.lviv.yuriizhurakovskyi.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "test")
public class Test {
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
    private User addedBy;
    @OneToMany(mappedBy = "test_question")
    private Set<TestQuestion> testQuestions;

    public Test() {
    }

    public Test(String name, Integer countOfQuestions, Level level) {
        this.name = name;
        this.countOfQuestions = countOfQuestions;
        this.level = level;
    }

    public Test(Integer id, String name, Integer countOfQuestions, Level level) {
        this.id = id;
        this.name = name;
        this.countOfQuestions = countOfQuestions;
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

    public Integer getCountOfQuestions() {
        return countOfQuestions;
    }

    public void setCountOfQuestions(Integer countOfQuestions) {
        this.countOfQuestions = countOfQuestions;
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
        Test test = (Test) o;
        return Objects.equals(id, test.id) && Objects.equals(name, test.name) && Objects.equals(countOfQuestions, test.countOfQuestions) && level == test.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countOfQuestions, level);
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countOfQuestions=" + countOfQuestions +
                ", level=" + level +
                '}';
    }
}
