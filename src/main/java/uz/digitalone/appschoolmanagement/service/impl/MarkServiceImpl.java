package uz.digitalone.appschoolmanagement.service.impl;

import org.springframework.stereotype.Service;
import uz.digitalone.appschoolmanagement.dto.MarkDto;
import uz.digitalone.appschoolmanagement.entity.Classes;
import uz.digitalone.appschoolmanagement.entity.Mark;
import uz.digitalone.appschoolmanagement.entity.User;
import uz.digitalone.appschoolmanagement.repository.ClassRepository;
import uz.digitalone.appschoolmanagement.repository.MarkRepository;
import uz.digitalone.appschoolmanagement.repository.UserRepository;
import uz.digitalone.appschoolmanagement.service.MarkService;

import java.util.List;
import java.util.Optional;


@Service
public class MarkServiceImpl implements MarkService {

    private final MarkRepository markRepository;
    private final UserRepository userRepository;
    private final ClassRepository classRepository;


    public MarkServiceImpl(MarkRepository markRepository,
                           UserRepository userRepository,
                           ClassRepository classRepository) {
        this.markRepository = markRepository;
        this.userRepository = userRepository;
        this.classRepository = classRepository;
    }

    @Override
    public Mark save(MarkDto dto) throws ClassNotFoundException {

        // GET USER BY USER ID
        Long userId = dto.getUserId();
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty())
            throw new ClassNotFoundException("Such User ID Not Found");
        User user = optionalUser.get();

        // GET CLASS BY CLASS ID
        Long classID = dto.getClassId();
        Optional<Classes> classOptional = classRepository.findById(classID);
        if (classOptional.isEmpty())
            throw new ClassNotFoundException("Such Class ID Not Found");
        Classes classes = classOptional.get();



        Mark mark = new Mark(
                dto.getScore(),
                dto.getGiven_date(),
                user,
                classes
        );

        Mark savedMark = markRepository.save(mark);

        return savedMark;
    }

    @Override
    public List<Mark> findAll() {
        return markRepository.findAll();
    }


    @Override
    public Mark findById(Long markId) throws ClassNotFoundException {
        Optional<Mark> markById = markRepository.findById(markId);
        if (markById.isEmpty())
            throw new ClassNotFoundException("Such Mark ID Not Found");
        Mark mark = markById.get();
        return mark;
    }

    @Override
    public Mark edit(Long id, MarkDto dto) throws ClassNotFoundException {

        // CHECK MARK
        Optional<Mark> optionalMarkId = markRepository.findById(id);
        if (optionalMarkId.isEmpty())
            throw new ClassNotFoundException("Such Mark ID Not Found");
        Mark mark = optionalMarkId.get();

        //CHECK SCORE
        Optional<Mark> optionalMarkScore = markRepository.findById(Long.valueOf(dto.getScore()));
        if (optionalMarkScore.isEmpty())
            throw new ClassNotFoundException("Score is empty");
        Mark markScore = optionalMarkScore.get();

        //CHECK USER
        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        if (optionalUser.isEmpty())
            throw new ClassNotFoundException("Such User ID Not Found");
        User user = optionalUser.get();

        //CHECK CLASS
        Optional<Classes> optionalClasses = classRepository.findById(dto.getClassId());
        if (optionalClasses.isEmpty())
            throw new ClassNotFoundException("Such Class ID Not Found");
        Classes classes = optionalClasses.get();

        if (!mark.getScore().equals(dto.getScore())) {
            mark.setScore(dto.getScore());
        }

        if (!mark.getStudent().getId().equals(dto.getUserId())) {
            mark.setStudent(user);
        }

        if (!mark.getClasses().getId().equals(dto.getClassId())) {
            mark.setClasses(classes);
        }

        Mark updatedMark = markRepository.save(mark);


        return updatedMark;
    }

    @Override
    public void remove(Long id) throws ClassNotFoundException {
        markRepository.deleteById(id);
        System.out.println("Deleted Mark");
    }

}
