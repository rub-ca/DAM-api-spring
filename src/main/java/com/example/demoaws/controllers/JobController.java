package com.example.demoaws.controllers;


import com.example.demoaws.models.Job;
import com.example.demoaws.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        return job;
        // Debe devolver null si no se encuentra?
        //return (job != null) ? job : new Job();
    }

    @PostMapping(consumes = {"application/json"})
    public Job saveJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }

}
