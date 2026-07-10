package com.sreeja.studentservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${course.service.url}")
    private String courseServiceUrl;

    @GetMapping("/students")
    public String getStudents() {

        log.info("Fetching students and calling Course Service");

        String courses = restTemplate.getForObject(
                courseServiceUrl + "/courses",
                String.class
        );

        log.info("Successfully received response from Course Service");

        return courses;
    }
}
