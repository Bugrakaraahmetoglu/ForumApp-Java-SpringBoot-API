package com.bugrak.quiz.repository;

import com.bugrak.quiz.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Integer> {
}
