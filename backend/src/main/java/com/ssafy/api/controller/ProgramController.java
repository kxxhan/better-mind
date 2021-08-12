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

import com.ssafy.api.request.ProgramPostReq;
import com.ssafy.api.request.ReviewPostReq;
import com.ssafy.api.response.ProgramGetRes;
import com.ssafy.api.service.ProgramService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Program;
import com.ssafy.db.entity.Program_Review;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "프로그램 api", tags = { "Program" })
@RestController
@RequestMapping("/api/v1/program")
public class ProgramController {

	@Autowired
	private ProgramService service;
	
	@Value("${server.tomcat.basedir}")
	private String basedir;
	
	@PostMapping()
	@ApiOperation(value = "프로그램 등록", notes = "<strong>프로그램 등록</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> createProgram(@RequestBody ProgramPostReq programPostReq,
			@RequestPart(value="file", required = false) MultipartFile[] files) {
		try {
			Program program = service.createProgram(programPostReq, files);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(BaseResponseBody.of(500, "fail"));
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(BaseResponseBody.of(500, "fail"));
		}
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@GetMapping("/allCount")
	@ApiOperation(value = "프로그램 전체 카운트", notes = "<strong>Page 구성</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<Long> getAllProgramCount() {
		long size = service.getAllProgramCount();
		return ResponseEntity.status(200).body(size);
	}
	
	@GetMapping("/all")
	@ApiOperation(value = "프로그램 전체 목록", notes = "<strong>page랑 한페이지에  들어갈 size</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<List<ProgramPostReq>> getAllProgram(Pageable pageable) {
		List<ProgramPostReq> programList = service.getAllProgram(pageable);
		return ResponseEntity.status(200).body(programList);
	}
	
	@GetMapping("/{programId}")
	@ApiOperation(value = "프로그램 상세", notes = "<strong>프로그램 상세</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<ProgramGetRes> getOneProgram(@PathVariable(name="programId")Long id) {
//		SsafyUserDetails userDetails = (SsafyUserDetails)authentication.getDetails();
//		String userId = userDetails.getUsername();
		ProgramGetRes program = service.getOneProgram(id);
		return ResponseEntity.status(200).body(program);
	}
	
	@GetMapping("/mpic")
	@ApiOperation(value="프로그램 메인 사진 정보")
	public void housepic(@RequestParam("sfolder") String sfolder, @RequestParam String ofile, 
			@RequestParam("sfile") String sfile, HttpServletResponse response) {
		String origin = basedir+File.separator+sfolder+File.separator+sfile;
		try {
			File down = new File(origin);
			FileInputStream is = new FileInputStream(down);
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Dispoition", "attachment; filename=\""+ofile+"\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			String mimeType = URLConnection.guessContentTypeFromName(origin);
			response.setContentType(mimeType);
			response.setContentLengthLong(down.length());
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
	
	@PutMapping("/{programId}")
	@ApiOperation(value = "프로그램 수정", notes = "<strong>프로그램 수정</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> putOneProgram(@PathVariable(name="programId")Long id, @RequestBody ProgramPostReq programPostReq) {
		Program result = service.updateProgram(id, programPostReq);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@DeleteMapping("/{programId}")
	@ApiOperation(value = "프로그램 삭제", notes = "<strong>프로그램 삭제</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> deleteOneProgram(@PathVariable(name="programId") Long id) {
		service.deleteProgram(id);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	// 후기
	@PostMapping("/{programId}")
	@ApiOperation(value = "후기 작성", notes = "<strong>후기 내용</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> createReview(@PathVariable(name="programId") Long id, @RequestBody ReviewPostReq review) {
		Program_Review program_review = service.createReview(id, review);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@PutMapping("{programId}/{reviewId}")
	@ApiOperation(value = "후기 수정", notes = "<strong>후기 수정</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<Program_Review> updateReview(@PathVariable(name="programId") Long pId,
			@PathVariable(name="reviewId") Long rId, @RequestBody ReviewPostReq review) {
		Program_Review program_review = service.updateReview(pId, rId, review);
		return ResponseEntity.status(200).body(program_review);
	}
	
	@DeleteMapping("{programId}/{reviewId}")
	@ApiOperation(value = "후기 삭제", notes = "<strong>후기 삭제</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> deleteReview(@PathVariable(name="programId") Long pId,
			@PathVariable(name="reviewId") Long rId) {
		service.deleteReview(pId, rId);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@GetMapping("/programlist/{programId}")
	@ApiOperation(value = "프로그램 신청자들", notes = "<strong>프로그램 신청자들</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<ProgramGetRes> getOneProgramUser(@PathVariable(name="programId")Long id) {
		ProgramGetRes program = service.getOneProgramUser(id);
		return ResponseEntity.status(200).body(program);
	}
}
