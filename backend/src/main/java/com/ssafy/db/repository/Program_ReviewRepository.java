package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.db.entity.Program_Review;

public interface Program_ReviewRepository extends JpaRepository<Program_Review, Long> {
	Optional<List<Program_Review>> findByProgram_id(Long program_id);
}

