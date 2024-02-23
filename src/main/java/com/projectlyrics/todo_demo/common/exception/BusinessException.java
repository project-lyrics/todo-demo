package com.projectlyrics.todo_demo.common.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

  private final HttpStatus responseStatus;
  private final ErrorCode errorCode;

  public BusinessException(HttpStatus responseStatus, ErrorCode errorCode, String message, Throwable cause) {
    super(message, cause);
    this.responseStatus = responseStatus;
    this.errorCode = errorCode;
  }

  public BusinessException(String message, HttpStatus responseStatus, ErrorCode errorCode) {
    super(message);
    this.responseStatus = responseStatus;
    this.errorCode = errorCode;
  }
}