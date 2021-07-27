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
	@ApiModelProperty(name="유저 ID", example="ssafy_web")
	private User user;	
	@ApiModelProperty(name="제목")
	private String title;
	@ApiModelProperty(name="내용")
	private String content;
}
