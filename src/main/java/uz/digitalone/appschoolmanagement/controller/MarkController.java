package uz.digitalone.appschoolmanagement.controller;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import uz.digitalone.appschoolmanagement.dto.MarkDto;
import uz.digitalone.appschoolmanagement.entity.Mark;
import uz.digitalone.appschoolmanagement.service.MarkService;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/27/2022
 * Time: 8:05 PM
 */

@RestController
public class MarkController {

    private final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }


    @RequestMapping(value = "/api/marks", method = RequestMethod.POST)
    public Mark save(@RequestBody MarkDto dto) throws ClassNotFoundException {
        return markService.save(dto);
    }


    @RequestMapping(value = "/api/marks", method = RequestMethod.GET)
    public List<Mark> findAll() {
        return markService.findAll();
    }

    @SneakyThrows
    @RequestMapping(value = "/api/marks/{id}", method = RequestMethod.GET)
    public Mark findById(@PathVariable("id") Long markId) {
        return markService.findById(markId);
    }

    @RequestMapping(value = "/api/marks/{id}", method = RequestMethod.PUT)
    public Mark edit(@PathVariable("id") Long id, @RequestBody MarkDto dto) throws ClassNotFoundException {
        return markService.edit(id, dto);
    }

    @RequestMapping(value = "/api/marks/{id}", method = RequestMethod.PUT)
    public Mark remove(@PathVariable("id") Long id) throws ClassNotFoundException {
        return markService.remove(id);
    }

}
