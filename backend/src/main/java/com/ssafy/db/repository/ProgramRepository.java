package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.db.entity.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {

}
