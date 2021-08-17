package com.ssafy.db.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Program;
import com.ssafy.db.entity.QProgram;

@Repository
public class ProgramRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QProgram qProgram = QProgram.program;
	
	public Optional<Program> findProgramByProgramid(Long program_id) {
        Program program = jpaQueryFactory.select(qProgram).from(qProgram)
                .where(qProgram.id.eq(program_id)).fetchOne();
        if(program == null) return Optional.empty();
        return Optional.ofNullable(program);
    }
}
