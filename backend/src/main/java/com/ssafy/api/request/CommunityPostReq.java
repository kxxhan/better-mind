package com.ssafy.api.request;

import java.util.Date;

import com.ssafy.db.entity.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("CommunityPostRequest")
public class CommunityPostReq {
	@ApiModelProperty(name="글 번호 ID", example="Long")
	private Long id;	
	@ApiModelProperty(name="유저 ID", example="ssafy_web")
	private String userId;	
	@ApiModelProperty(name="제목")
	private String title;
	@ApiModelProperty(name="내용")
	private String content;	
	@ApiModelProperty(name="분류")
	private String category;	
	@ApiModelProperty(name="나의 좋아요 설정 생성때는 필요없음")
	private boolean like;
	
	
}
