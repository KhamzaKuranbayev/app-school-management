package uz.digitalone.appschoolmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 7:24 PM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    /**
     * @OneToOne - One User To One Role
     * @ManyToOne - Many User To One Role  - ok
     * @ManyToMany - Many User To Many Role - ok
     * @OneToMany - One User To Many Role - ok
     */
    @ManyToOne
    private Role role;

    @OneToOne
    private Address address;

    @ManyToOne
    private School school;

    public User(String name, String email, Role role, Address address, School school) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.address = address;
        this.school = school;
    }
}
