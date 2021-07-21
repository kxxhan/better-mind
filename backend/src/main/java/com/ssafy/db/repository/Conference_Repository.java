package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.db.entity.Conference;

public interface Conference_Repository extends JpaRepository<Conference, Long> {

}
