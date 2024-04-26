package com.example.demoaws.models;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_id;
    private String job_title;
    private Long min_salary;
    private Long max_salary;

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Long getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(Long min_salary) {
        this.min_salary = min_salary;
    }

    public Long getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(Long max_salary) {
        this.max_salary = max_salary;
    }
}
