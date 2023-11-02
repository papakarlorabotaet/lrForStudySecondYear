package ru.fishev.MyRestSpringBootAppH2DB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fishev.MyRestSpringBootAppH2DB.dao.StudentDAO;
import ru.fishev.MyRestSpringBootAppH2DB.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getAllStudents( ){
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student getStudent(int id){
        return studentDAO.getStudent(id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);

    }

}
