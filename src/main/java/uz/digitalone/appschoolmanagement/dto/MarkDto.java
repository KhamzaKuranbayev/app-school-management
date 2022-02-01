package uz.digitalone.appschoolmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {
    private Integer score;
    private LocalDateTime given_date;
    private Long userId;
    private Long classId;

}
