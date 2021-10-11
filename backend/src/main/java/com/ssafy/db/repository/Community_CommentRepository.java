package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.db.entity.Community_Comment;
import com.ssafy.db.entity.Community_File;

public interface Community_CommentRepository extends JpaRepository<Community_Comment, Long>{
	Optional<List<Community_Comment>> findByCommunityarticle_id(Long community_article_id);
}
