package com.nizam.jobportal.repository;

import com.nizam.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ Add this line if missing
    User findByEmail(String email);
}
