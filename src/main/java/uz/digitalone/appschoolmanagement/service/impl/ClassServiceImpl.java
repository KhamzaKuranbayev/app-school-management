package uz.digitalone.appschoolmanagement.service.impl;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import uz.digitalone.appschoolmanagement.dto.ClassesDto;
import uz.digitalone.appschoolmanagement.entity.Classes;
import uz.digitalone.appschoolmanagement.entity.Subject;
import uz.digitalone.appschoolmanagement.entity.User;
import uz.digitalone.appschoolmanagement.repository.ClassRepository;
import uz.digitalone.appschoolmanagement.repository.SubjectRepository;
import uz.digitalone.appschoolmanagement.repository.UserRepository;
import uz.digitalone.appschoolmanagement.service.ClassService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 1/29/2022
 * Time: 7:51 PM
 */

@Service
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public ClassServiceImpl(ClassRepository classRepository,
                            SubjectRepository subjectRepository,
                            UserRepository userRepository) {
        this.classRepository = classRepository;
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
    }

    @SneakyThrows
    @Override
    public Classes save(ClassesDto dto) {
        Optional<Subject> byId = subjectRepository.findById(dto.getSubjectId());
        if (byId.isEmpty())
            throw new ClassNotFoundException("Subject Not Found");
        Subject subject = byId.get();

        Optional<User> optionalUser = userRepository.findById(dto.getTeacherId());
        if (optionalUser.isEmpty())
            throw new ClassNotFoundException("Teacher Not Found");
        User teacher = optionalUser.get();

        Classes classes = new Classes(
                dto.getName(),
                dto.getMaxStudent(),
                subject,
                teacher);

        Set<Long> studentIds = dto.getStudentIds();
        List<User> studentList = new ArrayList<>();
        for (Long studentId : studentIds) {
            Optional<User> optionalStudent = userRepository.findById(studentId);
            if(optionalStudent.isPresent()) {
                studentList.add(optionalStudent.get());
            }
        }
        classes.setStudents(studentList);

        Classes save = classRepository.save(classes);
        return save;
    }
}
