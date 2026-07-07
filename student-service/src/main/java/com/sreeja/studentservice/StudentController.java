package com.sreeja.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
@RestController
public class StudentController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${course.service.url}")
    private String courseServiceUrl;

    @GetMapping("/students")
    public String getStudents() {

        String courses = restTemplate.getForObject(
                courseServiceUrl + "/courses",
                String.class
        );

        return courses;
    }
}
