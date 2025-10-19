package com.nizam.jobportal.repository;

import com.nizam.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
