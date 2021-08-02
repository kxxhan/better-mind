package com.ssafy.db.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CategoryEnum {
	우울, 불안, 성격문제, 애착, 대인기피, 분노조절, 자존감, 중독, 대인관계, 부부, 가족상담;
	
	@JsonCreator
    public static CategoryEnum from(String s) {
        return CategoryEnum.valueOf(s);
    }
}
