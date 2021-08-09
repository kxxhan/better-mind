package com.ssafy.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.User;
import com.ssafy.db.entity.User_Program;

@Repository
public interface User_ProgramRepository extends JpaRepository<User_Program, Long>{
	Optional<User> findByUserid(String userId);
}

