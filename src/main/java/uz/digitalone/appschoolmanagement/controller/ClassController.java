package uz.digitalone.appschoolmanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.digitalone.appschoolmanagement.dto.ClassesDto;
import uz.digitalone.appschoolmanagement.entity.Classes;
import uz.digitalone.appschoolmanagement.service.ClassService;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 8:05 PM
 */

@RestController
@RequestMapping("/api/classes")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public Classes save(@RequestBody ClassesDto dto) {
        return classService.save(dto);
    }
}
