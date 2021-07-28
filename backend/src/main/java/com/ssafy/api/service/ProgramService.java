package com.ssafy.api.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("ProgramPostRequest")
public class ProgramService {
	@ApiModelProperty(name="전문가 ID", example="ssafy_expert")
	private String expert_id;
	@ApiModelProperty(name="프로그램 이름")
	private String name;
	@ApiModelProperty(name="프로그램 소개")
	private String report;
	@ApiModelProperty(name="카테고리")
	private String category;
	@ApiModelProperty(name="진행차시")
	private int count;
	@ApiModelProperty(name="비용")
	private int price;
	@ApiModelProperty(name="날짜, 요일, 시간")
	private String time;
	@ApiModelProperty(name="프로그램 첨부 파일", example="program_img")
	private String file_id;
	
}
