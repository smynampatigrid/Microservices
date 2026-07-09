package com.sreeja.courseservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @GetMapping("/courses")
    public List<Course> getCourses() {

        log.info("Fetching available courses");

        List<Course> courses = List.of(
                new Course(101, "Java Programming", "John"),
                new Course(102, "Spring Boot", "Alice"),
                new Course(103, "Microservices", "David")
        );

        log.info("Returning {} courses", courses.size());

        return courses;
    }
}
