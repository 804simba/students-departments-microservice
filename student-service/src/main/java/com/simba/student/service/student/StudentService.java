package com.simba.student.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.saveAndFlush(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> findStudentsByDepartmentId(Integer id) {
        return studentRepository.findAllByDepartmentId(id);
    }
}
