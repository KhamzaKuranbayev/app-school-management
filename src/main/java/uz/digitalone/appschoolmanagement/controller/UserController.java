package uz.digitalone.appschoolmanagement.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.appschoolmanagement.dto.UserCreateDto;
import uz.digitalone.appschoolmanagement.entity.User;
import uz.digitalone.appschoolmanagement.service.UserService;
import uz.digitalone.appschoolmanagement.service.impl.UserServiceImpl;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 8:04 PM
 */

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Save New User
     *
     * @param dto
     * @return
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public User save(@RequestBody UserCreateDto dto) throws ClassNotFoundException {
        User savedUser = userService.save(dto);
        return savedUser;
    }

    /**
     * Get All Users
     */
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> findAll() {
        System.out.println("Find All Methodiga kirdi");
        return userService.findAll();
    }

    @SneakyThrows
    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long userId) {
        return userService.findById(userId);
    }

    @SneakyThrows
    @RequestMapping(value = "/api/users/by_email/{email}", method = RequestMethod.GET)
    public User findById(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT)
    public User edit(@PathVariable Long id, @RequestBody UserCreateDto dto) throws ClassNotFoundException {
        return userService.edit(id, dto);
    }




}
