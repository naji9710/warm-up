package com.before.control.warmup.repositories;


import com.before.control.warmup.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getById(Long id);

    List<User> findAllByLogin(String login);
}
