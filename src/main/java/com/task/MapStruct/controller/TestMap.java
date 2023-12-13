package com.task.MapStruct.controller;

import com.task.MapStruct.service.ConvertMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/map")
public class TestMap {

    @Autowired
    private ConvertMap convertMap;

    @GetMapping()
    public ResponseEntity<?> test(){
        return ResponseEntity.ok(convertMap.val());
    }
}
