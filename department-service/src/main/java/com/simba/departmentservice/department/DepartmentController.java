package com.simba.departmentservice.department;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;


    @PostMapping
    public String saveDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
        return "Department saved successfully";
    }

    @GetMapping
    public ResponseEntity<List<Department>> findAllDepartments() {
        return ResponseEntity.ok(departmentService.findAllDepartments());
    }

    @GetMapping("/{department-id}/students")
    public ResponseEntity<FullDepartmentResponse> findAllDepartments(
            @PathVariable("department-id") Integer departmentId) {
        return ResponseEntity.ok(departmentService.findDepartmentsWithStudents(departmentId));
    }
}
