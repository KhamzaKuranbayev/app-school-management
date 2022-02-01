package uz.digitalone.appschoolmanagement.service;

import uz.digitalone.appschoolmanagement.dto.MarkDto;
import uz.digitalone.appschoolmanagement.entity.Mark;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 8:09 PM
 */
public interface MarkService {
    Mark save(MarkDto dto) throws ClassNotFoundException;

    List<Mark> findAll();

    Mark findById(Long markId) throws ClassNotFoundException;

    Mark edit(Long id, MarkDto dto) throws ClassNotFoundException;

    Mark remove(Long id) throws ClassNotFoundException;
}
