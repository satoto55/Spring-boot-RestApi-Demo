package com.example.restapi.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateForm {

    @NotBlank
    @Pattern(regexp = "^[\\x00-\\x7F]*$",message = "半角文字で入力してください")
    @Length(max=19,message = "19文字以内で入力してください")
    private String name;

    private String birthday;
}
