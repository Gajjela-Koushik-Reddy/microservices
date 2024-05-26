package com.koushikreddy.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseData {

    private String statusCode;
    private String statusMsg;
}
