package com.ssafy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.service.PostitService;

import io.swagger.annotations.Api;

@Api(value = "포스트잇 api", tags = { "Postit" })
@RestController
@RequestMapping("/api/v1/postit")
public class PostitController {

	@Autowired
	private PostitService service;
	
}
