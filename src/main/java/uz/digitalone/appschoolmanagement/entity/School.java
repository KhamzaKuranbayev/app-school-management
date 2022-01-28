package uz.digitalone.appschoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 7:16 PM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    /**
     *  One School To One Address
     */
    @OneToOne
    private Address address;


}
