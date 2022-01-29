package uz.digitalone.appschoolmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/29/2022
 * Time: 7:49 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesDto {
    private String name;
    private Integer maxStudent;
    private Long subjectId;
    private Long teacherId;
    private Set<Long> studentIds;
}
