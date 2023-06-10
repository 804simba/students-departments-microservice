package com.simba.departmentservice.client;

import com.simba.departmentservice.department.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "student-service",
        url = "${application.config.student-url}"
)
public interface StudentClient {
    @GetMapping("/department/{department-id}")
    List<Student> findStudentsByDepartmentId(@PathVariable("department-id") Integer departmentId);
}
