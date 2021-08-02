package com.ssafy.api.response;

import java.util.List;

import com.ssafy.api.request.CommentPostReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CommunityGetResponse")
public class CommunityGetRes {
	@ApiModelProperty(name="글 번호 ID", example="Long")
	private Long id;	
	@ApiModelProperty(name="유저 ID", example="ssafy_web")
	private String userId;	
	@ApiModelProperty(name="제목")
	private String title;
	@ApiModelProperty(name="내용")
	private String content;
	
	@ApiModelProperty(name="파일")
	private List<FileDto> files;
	
	@ApiModelProperty(name="코멘트")
	private List<CommentPostReq> comments;
	
}
