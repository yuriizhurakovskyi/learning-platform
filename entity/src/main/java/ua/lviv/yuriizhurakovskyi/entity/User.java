package ua.lviv.yuriizhurakovskyi.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
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
    private Set<Course> courses;
    @OneToMany(mappedBy = "test",
            cascade = CascadeType.ALL)
    private Set<Test> tests;


    public User() {
    }

    public User(String firstName, String lastName, Level level, Date dateOfBirth, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public User(Integer id, String firstName, String lastName, Level level, Date dateOfBirth, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Level getLevel() {
        return level;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && level == user.level && Objects.equals(dateOfBirth, user.dateOfBirth) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, level, dateOfBirth, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level=" + level +
                ", dateOfBirth=" + dateOfBirth +
                ", role=" + role +
                '}';
    }
}
