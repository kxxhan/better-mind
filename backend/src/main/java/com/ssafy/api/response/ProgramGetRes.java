package com.ssafy.api.response;

import java.util.List;

import com.ssafy.api.request.ReviewPostReq;
import com.ssafy.api.request.UserProgramPostReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ProgramGetResponse")
public class ProgramGetRes {
	
	@ApiModelProperty(name="프로그램 번호 ID", example="Long")
	private Long id;
	@ApiModelProperty(name="유저 ID", example = "ssafy_web")
	private String userId;
	@ApiModelProperty(name="프로그램 명")
	private String name;
	@ApiModelProperty(name="전문가 소개")
	private String description;
	@ApiModelProperty(name="프로그램 소개")
	private String report;
	@ApiModelProperty(name="프로그램 가격")
	private int price;
	@ApiModelProperty(name="프로그램 진행횟수")
	private int count;
	@ApiModelProperty(name="프로그램 날짜")
	private String date;
	@ApiModelProperty(name="프로그램 시간")
	private String time;
	@ApiModelProperty(name = "분류", example = "증상이나 감정")
	private String category;
	@ApiModelProperty(name="파일")
	private List<FileDto> files;
	@ApiModelProperty(name="리뷰")
	private List<ReviewPostReq> reviews;
	@ApiModelProperty(name="미팅타입")
	private String type;
	@ApiModelProperty(name="신청자들")
	private List<UserProgramPostReq> users;
	
}
