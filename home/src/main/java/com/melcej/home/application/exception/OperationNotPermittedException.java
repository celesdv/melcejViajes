package com.melcej.home.application.exception;

public class OperationNotPermittedException extends RuntimeException {

  public OperationNotPermittedException(String message) {
    super(message);
  }

}
