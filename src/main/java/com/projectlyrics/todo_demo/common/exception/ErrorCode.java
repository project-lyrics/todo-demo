package com.projectlyrics.todo_demo.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request", "000400"),
  PASSWORD_NOT_SET(HttpStatus.FORBIDDEN, "Password not set", "100001");

  private final HttpStatus responseStatus;
  private final String errorMessage;
  private final String errorCode;
}
