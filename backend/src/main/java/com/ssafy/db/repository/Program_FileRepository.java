package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.db.entity.Program_File;

public interface Program_FileRepository extends JpaRepository<Program_File, Long> {
	Optional<List<Program_File>> findByProgram(Long program_id);
}
