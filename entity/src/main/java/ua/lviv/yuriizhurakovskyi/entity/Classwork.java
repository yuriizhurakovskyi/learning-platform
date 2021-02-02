package ua.lviv.yuriizhurakovskyi.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "classwork")
public class Classwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cw_id")
    private Integer id;
    @Column(name = "cw_date")
    private Date date;
    @Column(name = "cw_solution")
    private String solution;
    @Column(name = "cw_result")
    private String result;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private User teacher;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private User student;
    @ManyToOne
    @JoinColumn(name = "tsk_id")
    private Task task;

    public Classwork() {
    }

    public Classwork(Date date, String solution, String result) {
        this.date = date;
        this.solution = solution;
        this.result = result;
    }

    public Classwork(Integer id, Date date, String solution, String result) {
        this.id = id;
        this.date = date;
        this.solution = solution;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classwork classwork = (Classwork) o;
        return Objects.equals(id, classwork.id) && Objects.equals(date, classwork.date) && Objects.equals(solution, classwork.solution) && Objects.equals(result, classwork.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, solution, result);
    }

    @Override
    public String toString() {
        return "Classwork{" +
                "id=" + id +
                ", date=" + date +
                ", solution='" + solution + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
