package org.generativeai.academicwritingassistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class AcademicWritingAssistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademicWritingAssistantApplication.class, args);
    }

}
