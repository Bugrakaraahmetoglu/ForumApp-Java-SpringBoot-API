package com.bugrak.quiz.repository;

import com.bugrak.quiz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoy extends JpaRepository<User, Integer> {
}
