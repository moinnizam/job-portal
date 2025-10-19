package com.nizam.jobportal.service;

import com.nizam.jobportal.entity.User;
import com.nizam.jobportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public User createOrUpdate(User user) {
        if (user.getId() != null) {
            Optional<User> existing = userRepository.findById(user.getId());
            if (existing.isPresent()) {
                User e = existing.get();
                e.setUsername(user.getUsername());
                e.setEmail(user.getEmail());
                e.setPhone(user.getPhone());
                e.setResume(user.getResume());
                return userRepository.save(e);
            }
        }
        return userRepository.save(user);
    }

    public User getById(Long id) { return userRepository.findById(id).orElse(null); }
    public void deleteById(Long id) { userRepository.deleteById(id); }
    public User getByEmail(String email) {
    return userRepository.findByEmail(email);
}

}