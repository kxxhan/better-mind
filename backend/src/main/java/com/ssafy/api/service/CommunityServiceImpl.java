package com.ssafy.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.db.entity.Community_Article;
import com.ssafy.db.repository.Community_ArticleRepository;
import com.ssafy.db.repository.UserRepository;

@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService {

	@Autowired
	Community_ArticleRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	CommunityArticleRepositorySupport repositorySupport;

	@Override
	public Community_Article createArticle(CommunityPostReq communityPostReq) {
		// TODO Auto-generated method stub
		Community_Article article = new Community_Article();
		article.setUser(userRepository.findByUserId(communityPostReq.getUserId()).get());
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
	public Community_Article putOneArticle(Long id,CommunityPostReq communityPostReq) {
		// TODO Auto-generated method stub
		Community_Article article = repository.getOne(id);
		article.setContent(communityPostReq.getContent());
		article.setTitle(communityPostReq.getTitle());
		article.setUpdated_at(new Date());
		return repository.save(article);
	}

	@Override
	public void deleteOneArticle(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
