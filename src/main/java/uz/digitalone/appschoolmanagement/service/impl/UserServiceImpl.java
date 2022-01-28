package uz.digitalone.appschoolmanagement.service.impl;

import org.springframework.stereotype.Service;
import uz.digitalone.appschoolmanagement.dto.UserCreateDto;
import uz.digitalone.appschoolmanagement.entity.Address;
import uz.digitalone.appschoolmanagement.entity.Role;
import uz.digitalone.appschoolmanagement.entity.School;
import uz.digitalone.appschoolmanagement.entity.User;
import uz.digitalone.appschoolmanagement.repository.AddressRepository;
import uz.digitalone.appschoolmanagement.repository.RoleRepository;
import uz.digitalone.appschoolmanagement.repository.SchoolRepository;
import uz.digitalone.appschoolmanagement.repository.UserRepository;
import uz.digitalone.appschoolmanagement.service.UserService;

import java.util.Optional;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 8:22 PM
 */

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;
    private final SchoolRepository schoolRepository;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           AddressRepository addressRepository,
                           SchoolRepository schoolRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.addressRepository = addressRepository;
        this.schoolRepository = schoolRepository;
    }


    @Override
    public User save(UserCreateDto dto) throws ClassNotFoundException {

        // ROLE ID ORQALI BAZADAN ROLE NI OLISH
        Long roleId = dto.getRoleId();
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isEmpty())
            throw new ClassNotFoundException("Such Role ID Not found");
        Role role = optionalRole.get();

        // Address ID ORQALI ADDRESS NI OLISH
        Long addressId = dto.getAddressId();
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isEmpty())
            throw new ClassNotFoundException("Such Address ID Not Found");
        Address address = optionalAddress.get();

        // School ID ORQALI SCHOOL OLISH
        Long schoolId = dto.getSchoolId();
        Optional<School> optionalSchool = schoolRepository.findById(schoolId);
        if (optionalSchool.isEmpty())
            throw new ClassNotFoundException("Such School ID Not Found");
        School school = optionalSchool.get();

        User user = new User(
                dto.getName(),
                dto.getEmail(),
                role,
                address,
                school);

        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
