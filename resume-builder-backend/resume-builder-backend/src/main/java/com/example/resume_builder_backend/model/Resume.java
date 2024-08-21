package com.example.resume_builder_backend.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resume {

    // Personal Information
    private String firstName;
    private String lastName;
    private String address;

    // Education
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Education {
        private String startYear;
        private String endYear;
        private String university;
        private String course;
    }
    private List<Education> education;

    // Skills
    private List<String> skills;

    // Languages
    private List<String> languages;

    // Work Experience
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WorkExperience {
        private String startYear;
        private String endYear;
        private String position;
        private String description;
    }
    private List<WorkExperience> workExperience;
}