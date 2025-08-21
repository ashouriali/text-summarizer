package com.example.summarizer.edge.dto;

import lombok.Data;

@Data
public class ResponseDto<T> {
    public T data;

    private ResponseDto(T data) {
        this.data = data;
    }

    public static <T> ResponseDto<T> of(T data) {
        return new ResponseDto<T>(data);
    }
}
