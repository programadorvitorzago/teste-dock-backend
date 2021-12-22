package com.example.DockApi.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.DockApi.Repositorio.Excecao.TerminalNotFoundException;

@ControllerAdvice
public class TerminalAdvice {
		
  @ResponseBody
  @ExceptionHandler(TerminalNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(TerminalNotFoundException ex) {
    return ex.getMessage();
  }
	
}
