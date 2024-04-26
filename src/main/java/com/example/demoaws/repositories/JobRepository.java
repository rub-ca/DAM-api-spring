package com.example.demoaws.repositories;

import com.example.demoaws.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
