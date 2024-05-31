package com.koushikreddy.loans.dto;

import java.time.LocalDate;

import org.springframework.web.servlet.resource.HttpResource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String apiPath;
    private HttpResource errorCode;
    private String errorMessage;
    private LocalDate errorTime;
}
