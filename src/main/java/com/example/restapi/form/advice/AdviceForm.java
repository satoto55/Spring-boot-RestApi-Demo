package com.example.restapi.form.advice;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class AdviceForm {

    private String type;

    private String message;
}
