package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("UserProgramPostRequest")
public class UserProgramPostReq {

	@ApiModelProperty(name="유저 ID")
	private Long user_id;
	@ApiModelProperty(name="프로그램 ID")
	private Long program_id;
}
