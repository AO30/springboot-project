package com.example.springbootproject.service;

import com.example.springbootproject.entity.Direction;
import com.example.springbootproject.entity.DirectionElective;
import com.example.springbootproject.entity.Student;
import com.example.springbootproject.repository.DirectionElectiveRepository;
import com.example.springbootproject.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DirectionService {
    @Autowired
    private DirectionService directionService;
    @Autowired
    private UserService userService;
    @Autowired
    private DirectionRepository directionRepository;
    @Autowired
    private DirectionElectiveRepository directionElectiveRepository;


    public Direction addDirection(Direction direction) {
        directionRepository.save(direction);
        return direction;
    }

    public Direction updateDirection(Direction direction) {
        directionRepository.save(direction);
        return direction;
    }

    public Direction getDirection(int id) {
        return directionRepository.findById(id).orElse(null);
    }

    public void deleteDirection(int id) {
        directionElectiveRepository.deleteById(id);
    }

    public DirectionElective addDirectionElective(int sid, int did) {
        Direction direction = directionService.getDirection(did);
        Student student = userService.getStudent(sid);
        DirectionElective directionElective = new DirectionElective();
        directionElective.setStudent(student);
        directionElective.setDirection(direction);
        directionElectiveRepository.save(directionElective);
        return directionElective;
    }

    public void deleteDirectionElective(int id) {
        directionElectiveRepository.deleteById(id);
    }

    public DirectionElective updateDirectionElective(DirectionElective directionElective){
        directionElectiveRepository.save(directionElective);
        return directionElective;
    }
}
