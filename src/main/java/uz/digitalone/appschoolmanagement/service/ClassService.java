package uz.digitalone.appschoolmanagement.service;

import uz.digitalone.appschoolmanagement.dto.ClassesDto;
import uz.digitalone.appschoolmanagement.entity.Classes;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 8:09 PM
 */
public interface ClassService {
    Classes save(ClassesDto dto);
}
