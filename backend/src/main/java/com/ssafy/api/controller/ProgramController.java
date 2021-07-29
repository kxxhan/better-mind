package com.ssafy.api.controller;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.ProgramPostReq;
import com.ssafy.api.service.ProgramService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.BaseEntity;
import com.ssafy.db.entity.Program;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(value = "프로그램 api", tags = { "Program" })
@RestController
@RequestMapping("/api/v1/program")
public class ProgramController {

	@Autowired
	private ProgramService service;
	
	@PostMapping()
	@ApiOperation(value = "프로그램 등록", notes = "<strong>프로그램 등록</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<BaseResponseBody> createProgram(@RequestBody ProgramPostReq programPostReq) {
		Program program = service.createProgram(programPostReq);
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
	
	public ResponseEntity<List<Program>> getAllProgram(Pageable pageable) {
		List<Program> programList = service.getAllProgram(pageable);
		return ResponseEntity.status(200).body(programList);
	}
	
	@GetMapping("/{programId}")
	@ApiOperation(value = "프로그램 상세", notes = "<strong>프로그램 상세</strong>")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "토큰 인증 실패"),
        @ApiResponse(code = 500, message = "서버 오류")
	})
	
	public ResponseEntity<Program> getOneProgram(@PathVariable(name="programId")Long id) {
		Program program = service.getOneProgram(id);
		return ResponseEntity.status(200).body(program);
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
}
