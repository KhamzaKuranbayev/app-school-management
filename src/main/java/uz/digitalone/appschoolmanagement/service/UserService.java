package uz.digitalone.appschoolmanagement.service;

import uz.digitalone.appschoolmanagement.dto.UserCreateDto;
import uz.digitalone.appschoolmanagement.entity.User;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 8:09 PM
 */
public interface UserService {

    User save(UserCreateDto dto) throws ClassNotFoundException;
}
