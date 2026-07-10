package com.sreeja.studentservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${course.service.url}")
    private String courseServiceUrl;

    @GetMapping("/students")
    @CircuitBreaker(name = "courseService", fallbackMethod = "fallbackCourses")
    @Retry(name = "courseService")
    public String getStudents() {

        return restTemplate.getForObject(
                "http://COURSE-SERVICE/courses",
                String.class
        );
    }

    public String fallbackCourses(Exception ex) {
        return "Course Service is currently unavailable. Please try again later.";
    }
}
