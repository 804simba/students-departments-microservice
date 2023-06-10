package com.simba.departmentservice.department;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FullDepartmentResponse {
    private String name;

    private String address;

    List<Student> students;
}
