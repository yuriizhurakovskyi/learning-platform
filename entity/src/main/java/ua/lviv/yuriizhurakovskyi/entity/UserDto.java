package ua.lviv.yuriizhurakovskyi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Integer id;
    @Column(name = "u_first_name")
    private String firstName;
    @Column(name = "u_last_name")
    private String lastName;
    @Column(name = "u_level")
    private Level level;
    @Column(name = "u_date_of_birth")
    private Date dateOfBirth;
    @Column(name = "u_role")
    private Role role;
    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL)
    private Set<CourseDto> cours;
    @OneToMany(mappedBy = "test",
            cascade = CascadeType.ALL)
    private Set<TestDto> testDtos;
}
