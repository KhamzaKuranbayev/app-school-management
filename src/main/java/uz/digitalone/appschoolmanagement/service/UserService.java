package uz.digitalone.appschoolmanagement.service;

import uz.digitalone.appschoolmanagement.dto.UserCreateDto;
import uz.digitalone.appschoolmanagement.entity.User;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 8:09 PM
 */
public interface UserService {
    User save(UserCreateDto dto) throws ClassNotFoundException;

    List<User> findAll();

    User findById(Long userId) throws ClassNotFoundException;

    User findByEmail(String email) throws ClassNotFoundException;

    User edit(Long id, UserCreateDto dto) throws ClassNotFoundException;

}
