package com.example.restapi.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UpdateForm {

    @NotBlank
    @Max(20)
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;

}
