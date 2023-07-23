package com.dev.gam.mswebfluxr2dbc.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {

  private int status;
  private String message;
  private LocalDateTime timestamp;
  private List<String> details;

}
