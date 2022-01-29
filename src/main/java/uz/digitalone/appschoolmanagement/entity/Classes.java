package uz.digitalone.appschoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 7:35 PM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer maxStudent;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private User teacher;

    /**
     * One Classes To Many Students
     */
    @OneToMany
    private List<User> students;

    public Classes(String name, Integer maxStudent, Subject subject, User teacher) {
        this.name = name;
        this.maxStudent = maxStudent;
        this.subject = subject;
        this.teacher = teacher;
    }

    /*

        id                  name                max_student                 subject_id              teacher_id
        1                   10-klass          10                            (JAVA) 5                (Khamza) 12
        2                   11-klass          8                             (JAVA) 5                (Khamza) 12
        2                   9-klass          8                             (JAVA) 5                (Sobir) 10
        2                   8-klass          8                             (JAVA) 5                (Tohir) 5


     */

}
