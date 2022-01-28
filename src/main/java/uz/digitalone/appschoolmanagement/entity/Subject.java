package uz.digitalone.appschoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 7:34 PM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;


}
