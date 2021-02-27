package ua.lviv.yuriizhurakovskyi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "classwork", schema = "learning_platform")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classwork {
    @Id
    @Column(name = "cw_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cw_date")
    private LocalDateTime date;
    @Column(name = "cw_solution")
    private String solution;
    @Column(name = "cw_result")
    private String result;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cw_task")
    private Task task;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cw_teacher")
    private User teacher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cw_student")
    private User student;
}
