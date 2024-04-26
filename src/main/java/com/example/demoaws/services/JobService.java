package com.example.demoaws.services;

import com.example.demoaws.models.Job;
import com.example.demoaws.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        if (id == null) return null;
        return jobRepository.findById(id).orElse(null);
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public Job updateJob(Long id, Job job) {
        Job jobToUpdate = jobRepository.findById(id).orElse(null);
        if (jobToUpdate == null) return null;
        jobToUpdate.setJob_title(job.getJob_title());
        jobToUpdate.setMin_salary(job.getMin_salary());
        jobToUpdate.setMax_salary(job.getMax_salary());
        return jobRepository.save(jobToUpdate);
    }
}
