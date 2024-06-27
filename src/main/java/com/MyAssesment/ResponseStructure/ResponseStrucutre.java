package com.MyAssesment.ResponseStructure;

import lombok.Data;

@Data
public class ResponseStrucutre<T> {
	private Integer statusCode;
	private  T data;
	private String message;

}
