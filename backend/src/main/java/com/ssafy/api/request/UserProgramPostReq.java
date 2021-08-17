package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Data
@ApiModel("UserProgramPostRequest")
public class UserProgramPostReq {
	
	@ApiModelProperty(name="유저 ID")
	private Long user_id;
	@ApiModelProperty(name="프로그램 ID")
	private Long program_id;
//	@ApiModelProperty(name="나의 프로그램 ID")
//	private Long myProgram_id;

}
