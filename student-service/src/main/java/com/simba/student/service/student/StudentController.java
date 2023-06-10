package com.simba.student.service.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public String saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student saved successfully";
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/department/{department-id}")
    public ResponseEntity<List<Student>> findStudentsByDepartmentId(@PathVariable(value = "department-id") Integer id) {
        return ResponseEntity.ok(studentService.findStudentsByDepartmentId(id));
    }
}
