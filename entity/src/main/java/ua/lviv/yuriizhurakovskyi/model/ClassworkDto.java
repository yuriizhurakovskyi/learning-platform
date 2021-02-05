package ua.lviv.yuriizhurakovskyi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "classwork")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassworkDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private UserDto teacher;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private UserDto student;
    @ManyToOne
    @JoinColumn(name = "tsk_id")
    private TaskDto taskDto;
}
