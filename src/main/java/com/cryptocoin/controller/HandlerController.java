package com.cryptocoin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class HandlerController {

	@ExceptionHandler(value=NoHandlerFoundException.class)
	public String NoHandlerFound(Model model){
	
		model.addAttribute("title","Not Found");
		return "error";
	}
}
