package uz.digitalone.appschoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 7:53 PM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 50, max = 100)
    private Integer score;                      // min = 50 max = 100   95

    private LocalDateTime givenDateTime;            // 2022-27-1 11:00:00

    @ManyToOne
    private User student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;


}
