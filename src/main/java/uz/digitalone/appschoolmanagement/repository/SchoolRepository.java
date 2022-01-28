package uz.digitalone.appschoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.digitalone.appschoolmanagement.entity.Address;
import uz.digitalone.appschoolmanagement.entity.School;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 8:07 PM
 */

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
}
