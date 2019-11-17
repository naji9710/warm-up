package com.before.control.warmup.repositories;


import com.before.control.warmup.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getById(Long id);
}
