package com.projectlyrics.todo_demo.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  private final ErrorCode errorCode;

  public BusinessException(ErrorCode errorCode, String messageForLog, Throwable cause) {
    super(messageForLog, cause);
    this.errorCode = errorCode;
  }

  public BusinessException(ErrorCode errorCode, String messageForLog) {
    super(messageForLog);
    this.errorCode = errorCode;
  }
}
