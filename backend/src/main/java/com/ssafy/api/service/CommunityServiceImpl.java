package com.ssafy.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.CommentPostReq;
import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.db.entity.Community_Article;
import com.ssafy.db.entity.Community_Comment;
import com.ssafy.db.repository.Community_ArticleRepository;
import com.ssafy.db.repository.Community_CommentRepository;
import com.ssafy.db.repository.UserRepository;

@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService {

	@Autowired
	Community_ArticleRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Community_CommentRepository commentRepository;

	@Override
	public Community_Article createArticle(CommunityPostReq communityPostReq) {
		// TODO Auto-generated method stub
		Community_Article article = new Community_Article();
		article.setUser(userRepository.findByUserid(communityPostReq.getUserId()).get());
		article.setContent(communityPostReq.getContent());
		article.setTitle(communityPostReq.getTitle());
		return repository.save(article);
	}

	@Override
	public List<Community_Article> getAllArticle(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public long getAllArticleCount() {
		// TODO Auto-generated method stub
		return repository.count();
	}

	@Override
	public Community_Article getOneArticle(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Community_Article updateArticle(Long id,CommunityPostReq communityPostReq) {
		// TODO Auto-generated method stub
		Community_Article article = repository.getOne(id);
		article.setContent(communityPostReq.getContent());
		article.setTitle(communityPostReq.getTitle());
		article.setUpdated_at(new Date());
		return repository.save(article);
	}

	@Override
	public void deleteArticle(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Community_Article createComment(Long id, CommentPostReq comment) {
		// TODO Auto-generated method stub
		Community_Comment com = new Community_Comment();
		com.setContent(comment.getContent());
		com.setUser(userRepository.findByUserid(comment.getUserId()).get());		
		Community_Article com2 = repository.getOne(id);
		com2.getComment().add(commentRepository.save(com));
		return com2;
	}

	@Override
	public Community_Comment updateComment(Long aId, Long cId, CommentPostReq comment) {
		// TODO Auto-generated method stub
		Community_Comment com =	commentRepository.getOne(cId);
		com.setContent(comment.getContent());
		com.setId(cId);
		return commentRepository.save(com);
	}

	@Override
	public void deleteComment(Long aId, Long cId) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(cId);
	}

}
