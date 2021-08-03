package com.ssafy.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.CommentPostReq;
import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.api.response.CommunityGetRes;
import com.ssafy.db.entity.Community_Article;
import com.ssafy.db.entity.Community_Comment;

public interface CommunityService {

	Community_Article createArticle(CommunityPostReq communityPostReq, MultipartFile[] files) throws IllegalStateException, IOException;

	long getAllArticleCount();

	CommunityGetRes getOneArticle(Long id,String userid);

	Community_Article updateArticle(Long id, CommunityPostReq communityPostReq);

	void deleteArticle(Long id);

	List<CommunityPostReq> getAllArticle(Pageable pageable,String userid);

	Community_Comment createComment(Long id, CommentPostReq comment);

	Community_Comment updateComment(Long aId, Long cId, CommentPostReq comment);

	void deleteComment(Long aId, Long cId);

	void upLike(Long aId, Long uId);

	void downLike(Long aId, Long uId);

}
