package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Program;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.User_Program;

@Repository
public interface User_ProgramRepository extends JpaRepository<User_Program, Long>{
	List<User_Program> findByUser_id(Long user_id);
	List<User_Program> findByProgram_id(Long program_id);
	Optional<User_Program> findByUser_idAndProgram_id(Long user_id,Long program_id);
	List<Program> findProgramListByUser_id(Long user_id);
	
//	Long findByUser_id1(Long user_id);
//	Long findByProgram_id1(Long program_id);
}

