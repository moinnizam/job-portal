package com.nizam.jobportal.service;

import com.nizam.jobportal.entity.Job;
import com.nizam.jobportal.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobService {
    private final JobRepository repo;
    public JobService(JobRepository repo){ this.repo = repo; }
    public Job create(Job job){ job.setPostedAt(LocalDateTime.now()); return repo.save(job); }
    public List<Job> list(){ return repo.findAll(); }
    public Job get(Long id){ return repo.findById(id).orElse(null); }
    public void delete(Long id){ repo.deleteById(id); }
}