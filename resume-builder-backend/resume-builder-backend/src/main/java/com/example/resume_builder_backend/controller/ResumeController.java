// package com.example.resume_builder_backend.controller;

// import java.io.IOException;

// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.resume_builder_backend.model.Resume;
// @CrossOrigin("*") 
// @RestController
// @RequestMapping("/api/resume")
// public class ResumeController {

//     private Resume savedResume;

//     @PostMapping("/submit")
//     public ResponseEntity<String> submitResume(@RequestBody Resume resume) {
//         // Save the resume data temporarily
//         this.savedResume = resume;
//         return ResponseEntity.ok("Resume submitted successfully!");
//     }

//     @GetMapping("/preview")
//     public ResponseEntity<Resume> previewResume() {
//         // Return the saved resume for preview
//         if (savedResume != null) {
//             return ResponseEntity.ok(savedResume);
//         } else {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }
//     }

//     @GetMapping("/download")
//     public ResponseEntity<byte[]> downloadResume() throws IOException {
//         // Convert the resume to PDF (or another format) and return as a byte array
//         // For simplicity, we're returning plain text in this example

//         if (savedResume == null) {
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }

//         String resumeContent = generateResumeContent(savedResume);

//         byte[] contentBytes = resumeContent.getBytes();
//         HttpHeaders headers = new HttpHeaders();
//         headers.add("Content-Disposition", "attachment; filename=resume.txt");
//         headers.add("Content-Type", "application/octet-stream");

//         return new ResponseEntity<>(contentBytes, headers, HttpStatus.OK);
//     }

//     private String generateResumeContent(Resume resume) {
//         StringBuilder builder = new StringBuilder();
//         builder.append("First Name: ").append(resume.getFirstName()).append("\n");
//         builder.append("Last Name: ").append(resume.getLastName()).append("\n");
//         builder.append("Address: ").append(resume.getAddress()).append("\n");

//         builder.append("Education:\n");
//         for (Resume.Education education : resume.getEducation()) {
//             builder.append(" - ").append(education.getStartYear()).append(" to ").append(education.getEndYear())
//                     .append(": ").append(education.getUniversity()).append(" (").append(education.getCourse()).append(")\n");
//         }

//         builder.append("Skills: ").append(String.join(", ", resume.getSkills())).append("\n");

//         builder.append("Languages: ").append(String.join(", ", resume.getLanguages())).append("\n");

//         builder.append("Work Experience:\n");
//         for (Resume.WorkExperience work : resume.getWorkExperience()) {
//             builder.append(" - ").append(work.getStartYear()).append(" to ").append(work.getEndYear())
//                     .append(": ").append(work.getPosition()).append("\n");
//             builder.append("   ").append(work.getDescription()).append("\n");
//         }

//         return builder.toString();
//     }
// }


//package com.example.resume_builder_backend.controller;

// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.resume_builder_backend.model.Resume;

// @CrossOrigin("*") 
// @RestController
// @RequestMapping("/api/resume")
// public class ResumeController {

//     @PostMapping("/submit")
//     public ResponseEntity<Resume> submitResume(@RequestBody Resume resume) {
//         // Directly return the submitted resume for preview
//         return ResponseEntity.ok(resume);
//     }
    
//     @PostMapping("/download")
//     public ResponseEntity<byte[]> downloadResume(@RequestBody Resume resume) {
//         // Convert the resume to PDF (or another format) and return as a byte array
//         // For simplicity, we're returning plain text in this example
//         String resumeContent = generateResumeContent(resume);

//         byte[] contentBytes = resumeContent.getBytes();
//         HttpHeaders headers = new HttpHeaders();
//         headers.add("Content-Disposition", "attachment; filename=resume.txt");
//         headers.add("Content-Type", "application/octet-stream");

//         return new ResponseEntity<>(contentBytes, headers, HttpStatus.OK);
//     }

//     private String generateResumeContent(Resume resume) {
//         StringBuilder builder = new StringBuilder();
//         builder.append("First Name: ").append(resume.getFirstName()).append("\n");
//         builder.append("Last Name: ").append(resume.getLastName()).append("\n");
//         builder.append("Address: ").append(resume.getAddress()).append("\n");

//         builder.append("Education:\n");
//         for (Resume.Education education : resume.getEducation()) {
//             builder.append(" - ").append(education.getStartYear()).append(" to ").append(education.getEndYear())
//                     .append(": ").append(education.getUniversity()).append(" (").append(education.getCourse()).append(")\n");
//         }

//         builder.append("Skills: ").append(String.join(", ", resume.getSkills())).append("\n");

//         builder.append("Languages: ").append(String.join(", ", resume.getLanguages())).append("\n");

//         builder.append("Work Experience:\n");
//         for (Resume.WorkExperience work : resume.getWorkExperience()) {
//             builder.append(" - ").append(work.getStartYear()).append(" to ").append(work.getEndYear())
//                     .append(": ").append(work.getPosition()).append("\n");
//             builder.append("   ").append(work.getDescription()).append("\n");
//         }

//         return builder.toString();
//     }
// }

package com.example.resume_builder_backend.controller;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resume_builder_backend.model.Resume;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private Resume savedResume;

    @PostMapping("/submit")
    public ResponseEntity<String> submitResume(@RequestBody Resume resume) {
        this.savedResume = resume;  // Update savedResume with the latest data
        return ResponseEntity.ok("Resume submitted successfully!");
    }

    @GetMapping("/preview")
    public ResponseEntity<Resume> previewResume() {
        if (savedResume != null) {
            return ResponseEntity.ok(savedResume);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadResume() throws IOException {
        if (savedResume == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        String resumeContent = generateResumeContent(savedResume);

        byte[] contentBytes = resumeContent.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=resume.txt");
        headers.add("Content-Type", "application/octet-stream");

        return new ResponseEntity<>(contentBytes, headers, HttpStatus.OK);
    }

    private String generateResumeContent(Resume resume) {
        StringBuilder builder = new StringBuilder();
        builder.append("First Name: ").append(resume.getFirstName()).append("\n");
        builder.append("Last Name: ").append(resume.getLastName()).append("\n");
        builder.append("Address: ").append(resume.getAddress()).append("\n");

        builder.append("Education:\n");
        for (Resume.Education education : resume.getEducation()) {
            builder.append(" - ").append(education.getStartYear()).append(" to ").append(education.getEndYear())
                    .append(": ").append(education.getUniversity()).append(" (").append(education.getCourse()).append(")\n");
        }

        builder.append("Skills: ").append(String.join(", ", resume.getSkills())).append("\n");

        builder.append("Languages: ").append(String.join(", ", resume.getLanguages())).append("\n");

        builder.append("Work Experience:\n");
        for (Resume.WorkExperience work : resume.getWorkExperience()) {
            builder.append(" - ").append(work.getStartYear()).append(" to ").append(work.getEndYear())
                    .append(": ").append(work.getPosition()).append("\n");
            builder.append("   ").append(work.getDescription()).append("\n");
        }

        return builder.toString();
    }
}


