package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.db.entity.Community_File;

public interface Community_FileRepository extends JpaRepository<Community_File, Long> {
	Optional<List<Community_File>> findByCommunityarticle(Long community_article_id);
}
