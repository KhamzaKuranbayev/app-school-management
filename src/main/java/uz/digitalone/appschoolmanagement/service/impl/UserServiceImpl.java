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

import java.util.List;
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

    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User findById(Long userId) throws ClassNotFoundException {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty())
            throw new ClassNotFoundException("User Not Found with ID {" + userId + "}");
        User user = byId.get();
        return user;
    }

    @Override
    public User findByEmail(String email) throws ClassNotFoundException {
        Optional<User> byId = userRepository.findByEmail(email);
        if (byId.isEmpty())
            throw new ClassNotFoundException("User Not Found with Email {" + email + "}");
        User user = byId.get();
        return user;
    }

    @Override
    public User edit(Long userId, UserCreateDto dto) throws ClassNotFoundException {

        // CHECK USER
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isEmpty())
            throw new ClassNotFoundException("User Not Found with ID {" + userId + "}");
        User user = byId.get();

        // CHECK ROLE

        Optional<Role> optionalRole = roleRepository.findById(dto.getRoleId());
        if (optionalRole.isEmpty())
            throw new ClassNotFoundException("Role Not Found with ID {" + dto.getRoleId() + "}");
        Role role = optionalRole.get();

        // CHECK ADDRESS
        Optional<Address> optionalAddress = addressRepository.findById(dto.getAddressId());
        if (optionalAddress.isEmpty())
            throw new ClassNotFoundException("Address Not Found with ID {" + dto.getAddressId() + "}");
        Address address = optionalAddress.get();

        // CHECK SCHOOL
        Optional<School> optionalSchool = schoolRepository.findById(dto.getSchoolId());
        if (optionalSchool.isEmpty())
            throw new ClassNotFoundException("School Not Found with ID {" + dto.getSchoolId() + "}");
        School school = optionalSchool.get();

        if (!user.getName().equals(dto.getName())) {
            user.setName(dto.getName());
        }

        if (!user.getEmail().equals(dto.getEmail())) {
            user.setEmail(dto.getEmail());
        }

        if (!user.getRole().getId().equals(dto.getRoleId())) {
            user.setRole(role);
        }

        if (!user.getAddress().getId().equals(dto.getAddressId())) {
            user.setAddress(address);
        }

        if (!user.getSchool().getId().equals(dto.getSchoolId())) {
            user.setSchool(school);
        }

        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
