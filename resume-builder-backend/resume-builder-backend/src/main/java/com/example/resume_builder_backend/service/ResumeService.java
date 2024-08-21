package com.example.resume_builder_backend.service;



import org.springframework.stereotype.Service;

import com.example.resume_builder_backend.model.Resume;

@Service
public class ResumeService {
    private Resume resume;

    public void saveResume(Resume resume) {
        this.resume = resume;
    }

    public Resume getResume() {
        return this.resume;
    }

    // Method to convert resume to PDF and download (to be implemented)
}
