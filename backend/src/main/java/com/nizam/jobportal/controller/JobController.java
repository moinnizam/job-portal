package com.nizam.jobportal.controller;

import com.nizam.jobportal.entity.Job;
import com.nizam.jobportal.service.JobService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {
    private final JobService service;
    public JobController(JobService service){ this.service = service; }

    @PostMapping
    public Job create(@RequestBody Job job){ return service.create(job); }

    @GetMapping
    public List<Job> list(){ return service.list(); }

    @GetMapping("/{id}")
    public Job get(@PathVariable Long id){ return service.get(id); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ service.delete(id); }
}
