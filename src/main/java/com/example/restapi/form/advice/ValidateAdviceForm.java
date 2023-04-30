package com.example.restapi.form.advice;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ValidateAdviceForm {

    private String type;

    private String message;

    private Map<String,String> invalid_params = new HashMap<>();
}
