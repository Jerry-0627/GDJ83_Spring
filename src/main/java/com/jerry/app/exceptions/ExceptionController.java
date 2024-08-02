package com.jerry.app.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 예외를 전문적으로 처리하는 애들임

//@RestControllerAdvice라는 애도 있음. ajax로 요청헀을 때 exception이 발생했을 때 사용함.
//jsp 안쓰고 프론트와 백이 완전히 분리 되었을 떄 사용할 수 있음.
@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Throwable.class)
	public String exceprion(Model model) {
	return "errors/error_400";
	}

}
