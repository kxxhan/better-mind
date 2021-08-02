package com.ssafy.api.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.api.request.CommentPostReq;
import com.ssafy.api.request.CommunityPostReq;
import com.ssafy.api.response.CommunityGetRes;
import com.ssafy.api.service.CommunityService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Community_Article;
import com.ssafy.db.entity.Community_Comment;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "커뮤니티 게시판", tags = { "Article" })
@RestController
@RequestMapping("/api/v1/article")
public class CommunityController {

	@Autowired
	private CommunityService service;

	// 저장할 기본 디렉토리 설정 application.property 파일에 설정하고 가져온다.
	@Value("${server.tomcat.basedir}")
	private String basedir;
	
	@PostMapping()
	@ApiOperation(value = "글 작성", notes = "<strong>글 작성</strong>")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "토큰 인증 실패"),
			@ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<BaseResponseBody> createArticle(@RequestBody CommunityPostReq communityPostReq,
			@RequestPart(value = "file", required = false) MultipartFile[] files) {
		try {
			Community_Article article = service.createArticle(communityPostReq,files);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(500).body(BaseResponseBody.of(500, "Fail"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(500).body(BaseResponseBody.of(500, "Fail"));
		}
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@GetMapping("/allCount")
	@ApiOperation(value = "글 전체 카운트", notes = "<strong>Page 구성</strong>")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "토큰 인증 실패"),
			@ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<Long> getAllArticleCount() {

		long size = service.getAllArticleCount();
		return ResponseEntity.status(200).body(size);
	}

	@GetMapping("/all")
	@ApiOperation(value = "글 전체 목록", notes = "<strong>page랑 한페이지에  들어갈 size >> ?size=10&page=1</strong>")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "토큰 인증 실패"),
			@ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<List<CommunityPostReq>> getAllArticle(@PageableDefault(page = 0,size = 10) Pageable pageable) {

		List<CommunityPostReq> articleList = service.getAllArticle(pageable);
		return ResponseEntity.status(200).body(articleList);
	}

	@GetMapping("/{articleId}")
	@ApiOperation(value = "글 내용", notes = "<strong>글 내용</strong>")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "토큰 인증 실패"),
			@ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<CommunityGetRes> getOneArticle(@PathVariable(name = "articleId") Long id) {

		CommunityGetRes article = service.getOneArticle(id);
		return ResponseEntity.status(200).body(article);
	}
	
	@GetMapping("/pic")
	@ApiOperation(value = "글에 등록된 사진 정보")
	public void housepic(@RequestParam("sfolder") String sfolder, @RequestParam("ofile") String ofile,
			@RequestParam("sfile") String sfile, HttpServletResponse response) {
		String origin = basedir + File.separator + sfolder + File.separator + sfile;
		try {
			File down = new File(origin);
			FileInputStream is = new FileInputStream(down);// 서버에 저장된 파일 읽어서

			response.setContentType("application/octet-stream"); // 모든 content-type을 구성할 수 있는 설정
			// 헤더 설정 전송 인코딩
			response.setHeader("Content-Disposition", "attachment; filename=\"" + ofile + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			// 이름을 통해 콘텐트 타입을 가져온다.
			String mimeType = URLConnection.guessContentTypeFromName(origin);
			response.setContentType(mimeType);
			// 콘텐츠 길이를 설정
			response.setContentLengthLong(down.length());
			// 데이터 전송
			ServletOutputStream os = response.getOutputStream();
			FileCopyUtils.copy(is, os);
			os.flush();
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PutMapping("/{articleId}")
	@ApiOperation(value = "글 수정", notes = "<strong>글 수정</strong>")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "토큰 인증 실패"),
			@ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<BaseResponseBody> putOneArticle(@PathVariable(name = "articleId") Long id,
			@RequestBody CommunityPostReq communityPostReq) {

		Community_Article result = service.updateArticle(id, communityPostReq);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@DeleteMapping("/{articleId}")
	@ApiOperation(value = "글 삭제", notes = "<strong>글 삭제</strong>")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "토큰 인증 실패"),
			@ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<BaseResponseBody> deleteOneArticle(@PathVariable(name = "articleId") Long id) {

		service.deleteArticle(id);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@PostMapping("/{articleId}")
	@ApiOperation(value = "댓글 작성", notes = "<strong>댓글 내용</strong>")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "토큰 인증 실패"),
			@ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<BaseResponseBody> createComment(@PathVariable(name = "articleId") Long id,
			@RequestBody CommentPostReq comment) {

		Community_Comment community_Comment = service.createComment(id, comment);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}

	@PutMapping("/{articleId}/{commentId}")
	@ApiOperation(value = "댓글 수정", notes = "<strong>댓글 내용</strong>")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "토큰 인증 실패"),
			@ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<Community_Comment> updateComment(@PathVariable(name = "articleId") Long aId,
			@PathVariable(name = "commentId") Long cId, @RequestBody CommentPostReq comment) {

		Community_Comment community_comment = service.updateComment(aId, cId, comment);
		return ResponseEntity.status(200).body(community_comment);
	}

	@DeleteMapping("/{articleId}/{commentId}")
	@ApiOperation(value = "댓글 삭제", notes = "<strong>댓글 내용</strong>")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "토큰 인증 실패"),
			@ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<BaseResponseBody> deleteComment(@PathVariable(name = "articleId") Long aId,
			@PathVariable(name = "commentId") Long cId) {

		service.deleteComment(aId, cId);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
}
