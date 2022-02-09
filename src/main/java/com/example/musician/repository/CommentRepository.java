package com.example.musician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.musician.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}