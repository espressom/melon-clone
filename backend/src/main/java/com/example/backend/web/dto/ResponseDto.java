package com.example.backend.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ResponseDto {

    private HttpStatus status;
    private String msg;

    @Builder
    public ResponseDto(HttpStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
