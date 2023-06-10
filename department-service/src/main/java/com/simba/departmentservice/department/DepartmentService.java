package com.simba.departmentservice.department;

import com.simba.departmentservice.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final StudentClient studentClient;

    public void saveDepartment(Department department) {
        departmentRepository.saveAndFlush(department);
    }

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public FullDepartmentResponse findDepartmentsWithStudents(Integer departmentId) {
        var department = departmentRepository.findById(departmentId)
                .orElse(Department.builder()
                        .departmentName("NOT FOUND")
                        .departmentAddress("NOT FOUND")
                        .build());

        // TODO: find all students from the student-service
        var students = studentClient.findStudentsByDepartmentId(departmentId);
        return FullDepartmentResponse.builder()
                .name(department.getDepartmentName())
                .address(department.getDepartmentAddress())
                .students(students)
                .build();
    }
}
