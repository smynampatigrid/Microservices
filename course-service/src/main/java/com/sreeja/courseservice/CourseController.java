package com.sreeja.courseservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Course> getCourses() {

        return List.of(
                new Course(101, "Java Programming", "John"),
                new Course(102, "Spring Boot", "Alice"),
                new Course(103, "Microservices", "David")
        );
    }
}
