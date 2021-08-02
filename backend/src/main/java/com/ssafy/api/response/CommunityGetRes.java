package com.ssafy.api.response;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CommunityGetResponse")
public class CommunityGetRes {
	@ApiModelProperty(name="유저 ID", example="ssafy_web")
	private String userId;	
	@ApiModelProperty(name="제목")
	private String title;
	@ApiModelProperty(name="내용")
	private String content;
	
	@ApiModelProperty(name="파일")
	private List<FileDto> files;
	
	
}
