package uz.digitalone.appschoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.digitalone.appschoolmanagement.entity.enums.WeekDays;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 7:44 PM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "time_tables")
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classes classes;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @Enumerated(EnumType.STRING)
    private WeekDays weekday;

}
