package com.ssafy.api.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.CommentPostReq;
import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.api.response.CommunityGetRes;
import com.ssafy.api.response.FileDto;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.db.entity.Article_Like;
import com.ssafy.db.entity.CategoryEnum;
import com.ssafy.db.entity.Community_Article;
import com.ssafy.db.entity.Community_Comment;
import com.ssafy.db.entity.Community_File;
import com.ssafy.db.repository.Article_LikeRepository;
import com.ssafy.db.repository.Community_ArticleRepository;
import com.ssafy.db.repository.Community_CommentRepository;
import com.ssafy.db.repository.Community_FileRepository;
import com.ssafy.db.repository.UserRepository;

import springfox.documentation.annotations.ApiIgnore;

@Service("CommunityService")
public class CommunityServiceImpl implements CommunityService {

	@Autowired
	Community_ArticleRepository repository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	Community_CommentRepository commentRepository;

	@Autowired
	Community_FileRepository fileRepository;
	
	@Autowired
	Article_LikeRepository likeRepository;

	// 저장할 기본 디렉토리 설정 application.property 파일에 설정하고 가져온다.
	@Value("${server.tomcat.basedir}")
	private String basedir;

	@Override
	@Transactional
	public Community_Article createArticle(CommunityPostReq communityPostReq, MultipartFile[] files)
			throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		Community_Article article = new Community_Article();
		article.setUser(userRepository.findByUserid(communityPostReq.getUserId()).get());
		article.setContent(communityPostReq.getContent());
		article.setTitle(communityPostReq.getTitle());
		article.setCategory(CategoryEnum.valueOf(communityPostReq.getCategory()));
		article = repository.save(article);
		if (files != null) {
			String realPath = basedir;
			// 오늘날짜로 폴더 설정
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			// 실제 저장하는 폴더주소
			String saveFolder = realPath + File.separator + today;
			// 저장 폴더 주소를 불러왔는데
			File folder = new File(saveFolder);
			// 폴더가 존재하지 않으면 폴더 생성
			if (!folder.exists())
				folder.mkdirs();
			for (MultipartFile f : files) {
				// 원래 파일의 이름
				String originalFileName = f.getOriginalFilename();
				if (!originalFileName.isEmpty()) {
					// 랜덤한 파일이름으로 가상 파일 이름을 생성시켜준다. subString을 통해서 확장자까지 저장
					String saveFileName = UUID.randomUUID().toString()
							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
					f.transferTo(new File(folder, saveFileName));
					Community_File cfile = new Community_File();
					cfile.setSavefolder(saveFolder);
					cfile.setCommunityarticle(article);
					cfile.setOriginfile(originalFileName);
					cfile.setSavefile(saveFileName);
					fileRepository.save(cfile);
				}
			}
		}
		return article;
	}

	@Override
	public List<CommunityPostReq> getAllArticle(Pageable pageable,String userId) {
		// TODO Auto-generated method stub
		Long uid = userRepository.findByUserid(userId).get().getId();
		List<Community_Article> list = repository.findAll(pageable).getContent();
		List<CommunityPostReq> copy = new ArrayList<>();
		CommunityPostReq resp;
		for (Community_Article c : list) {
			resp = new CommunityPostReq();
			resp.setLike(likeRepository.findByUser_idAndArticle_id(uid, c.getId()).isPresent());
			resp.setLikeCount(c.getLike());
			resp.setId(c.getId());
			resp.setTitle(c.getTitle());
			resp.setUserId(c.getUser().getUserid());
			resp.setContent(c.getContent());
			resp.setCategory(c.getCategory().name());
			copy.add(resp);
			List<Community_Comment> clist = commentRepository.findByCommunityarticle_id(c.getId()).get();
			if(clist != null) {
				List<CommentPostReq> comments = new ArrayList<>();
				for(Community_Comment k: clist) {
					CommentPostReq l = new CommentPostReq();
					l.setId(k.getId());
					l.setContent(k.getContent());
					l.setUserId(k.getUser().getUserid());
					comments.add(l);
				}
				resp.setCommentCount(comments.size());
			}
		}
		return copy;
	}

	@Override
	public long getAllArticleCount() {
		// TODO Auto-generated method stub
		return repository.count();
	}

	@Override
	public CommunityGetRes getOneArticle(Long id,String userId) {
		// TODO Auto-generated method stub
		Community_Article article = repository.findById(id).get();
		Long uid = userRepository.findByUserid(userId).get().getId();
		CommunityGetRes c = new CommunityGetRes();
		c.setId(article.getId());
		c.setContent(article.getContent());
		c.setTitle(article.getTitle());
		c.setCategory(article.getCategory().name());
		c.setUserId(article.getUser().getUserid());
		c.setLike(likeRepository.findByUser_idAndArticle_id(uid, c.getId()).isPresent());
		c.setLikeCount(article.getLike());
		List<Community_Comment> clist = commentRepository.findByCommunityarticle_id(article.getId()).get();
		if(clist != null) {
			List<CommentPostReq> comments = new ArrayList<>();
			for(Community_Comment k: clist) {
				CommentPostReq l = new CommentPostReq();
				l.setId(k.getId());
				l.setContent(k.getContent());
				l.setUserId(k.getUser().getUserid());
				comments.add(l);
			}
			c.setComments(comments);
		}
		List<Community_File> list = fileRepository.findByCommunityarticle_id(id).get();
		if (list != null) {
			List<FileDto> copy = new ArrayList<>();
			for (Community_File fi : list) {
				FileDto dto = new FileDto();
				dto.setOriginfile(fi.getOriginfile());
				dto.setSavefile(fi.getSavefile());
				dto.setSavefolder(fi.getSavefolder());
				copy.add(dto);
			}
			c.setFiles(copy);
		}
		return c;
	}

	@Override
	public Community_Article updateArticle(Long id, CommunityPostReq communityPostReq) {
		// TODO Auto-generated method stub
		Community_Article article = repository.getOne(id);
		article.setContent(communityPostReq.getContent());
		article.setTitle(communityPostReq.getTitle());
		article.setCategory(CategoryEnum.valueOf(communityPostReq.getCategory()));
		article.setUpdated_at(new Date());
		return repository.save(article);
	}

	@Override
	public void deleteArticle(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Community_Comment createComment(Long id, CommentPostReq comment) {
		// TODO Auto-generated method stub
		Community_Comment com = new Community_Comment();
		com.setContent(comment.getContent());
		com.setUser(userRepository.findByUserid(comment.getUserId()).get());
		Community_Article com2 = repository.getOne(id);
		com.setCommunityarticle(com2);
		return commentRepository.save(com);
	}

	@Override
	public Community_Comment updateComment(Long aId, Long cId, CommentPostReq comment) {
		// TODO Auto-generated method stub
		Community_Comment com = commentRepository.getOne(cId);
		com.setContent(comment.getContent());
		com.setUpdated_at(new Date());
		return commentRepository.save(com);
	}

	@Override
	public void deleteComment(Long aId, Long cId) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(cId);
	}
	@Override
	public void upLike(Long aId, Long uId) {
		// TODO Auto-generated method stub
		Article_Like like = new Article_Like();
		like.setArticle(repository.getOne(aId));
		like.setUser(userRepository.getOne(uId));
		likeRepository.save(like);
		Community_Article article = repository.getOne(aId);
		article.setLike(article.getLike()+1);
		repository.save(article);
		
	}
	@Override
	public void downLike(Long aId, Long uId) {
		// TODO Auto-generated method stub
		likeRepository.deleteById(((CommentPostReq) likeRepository.findByUser_idAndArticle_id(uId, aId).get()).getId());
		Community_Article article = repository.getOne(aId);
		article.setLike(article.getLike()-1);
		repository.save(article);
	}
	

}
