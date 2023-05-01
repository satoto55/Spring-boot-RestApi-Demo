package com.example.restapi.advice;

import com.example.restapi.form.advice.AdviceForm;
import com.example.restapi.form.advice.ValidateAdviceForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidateAdviceForm handleInvalidArgument(MethodArgumentNotValidException ex){
        ValidateAdviceForm validateAdviceForm = new ValidateAdviceForm();
        validateAdviceForm.setType("Invalid_Params");
        validateAdviceForm.setMessage("Your request parameters didn't validate");
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                { errorMap.put(error.getField(),error.getDefaultMessage());
                });
        validateAdviceForm.setInvalidParams(errorMap);
        return validateAdviceForm;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public AdviceForm handleParseError(HttpMessageNotReadableException ex){
        AdviceForm adviceForm = new AdviceForm();
        adviceForm.setType("Invalid_request_body");
        adviceForm.setMessage("Your request body didn't validate");
        return adviceForm;
    }
}
