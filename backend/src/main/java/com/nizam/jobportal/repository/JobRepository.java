package com.nizam.jobportal.repository;

import com.nizam.jobportal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {}
