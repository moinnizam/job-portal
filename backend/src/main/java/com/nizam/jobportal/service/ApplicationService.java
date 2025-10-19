package com.nizam.jobportal.service;

import com.nizam.jobportal.entity.Application;
import com.nizam.jobportal.entity.Job;
import com.nizam.jobportal.entity.User;
import com.nizam.jobportal.repository.ApplicationRepository;
import com.nizam.jobportal.repository.JobRepository;
import com.nizam.jobportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public ApplicationService(ApplicationRepository applicationRepository,
                              UserRepository userRepository,
                              JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    public Application apply(Long userId, Long jobId, String resumeText) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));

        Application application = new Application();
        application.setUser(user);
        application.setJob(job);
        application.setAppliedAt(LocalDateTime.now());
        application.setStatus("APPLIED");
        return applicationRepository.save(application);
    }

    public List<Application> getByUser(Long userId) { return applicationRepository.findByUserId(userId); }
    public List<Application> getByJob(Long jobId) { return applicationRepository.findByJobId(jobId); }
}
