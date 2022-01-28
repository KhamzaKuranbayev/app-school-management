package uz.digitalone.appschoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.digitalone.appschoolmanagement.entity.Address;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 8:07 PM
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
