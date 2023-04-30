package com.example.restapi.controller;

import com.example.restapi.form.CreateForm;
import com.example.restapi.form.UpdateForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class NameController {

    @GetMapping("/names")
    public List<String> getNames(@RequestParam(name = "name", required = false,defaultValue = "") String name
            ,@RequestParam(name = "birthday", required = false,defaultValue = "") String birthday){

        return List.of(name,birthday);
    }

    @PostMapping("/names")
    public ResponseEntity<String> create(@Validated @RequestBody CreateForm form) {

        // 登録処理は省略
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id") // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        // 更新処理は省略
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        // 更新処理は省略
        return ResponseEntity.ok(Map.of("message", "name successfully delete"));
    }
}
