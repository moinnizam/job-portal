package com.nizam.jobportal.controller;

import com.nizam.jobportal.entity.Application;
import com.nizam.jobportal.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {
    private final ApplicationService applicationService;
    public ApplicationController(ApplicationService applicationService) { this.applicationService = applicationService; }

    @PostMapping
    public ResponseEntity<Application> apply(@RequestBody Map<String, Object> body) {
        Long userId = Long.valueOf(String.valueOf(body.get("userId")));
        Long jobId = Long.valueOf(String.valueOf(body.get("jobId")));
        String resume = body.containsKey("resume") ? String.valueOf(body.get("resume")) : null;
        Application app = applicationService.apply(userId, jobId, resume);
        return ResponseEntity.ok(app);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Application>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(applicationService.getByUser(userId));
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Application>> byJob(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.getByJob(jobId));
    }
}
