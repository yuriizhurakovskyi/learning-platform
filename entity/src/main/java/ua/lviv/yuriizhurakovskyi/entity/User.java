package ua.lviv.yuriizhurakovskyi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users", schema = "learning_platform")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "u_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "u_firstname")
    private String firstName;
    @Column(name = "u_lastname")
    private String lastName;
    @Column(name = "u_level")
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(name = "u_date_of_birth")
    private LocalDateTime dateOfBirth;
    @Column(name = "u_role")
    @Enumerated(EnumType.STRING)
    private Role role;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
//    private List<Course> courses;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
//    private List<Test> tests;
}
