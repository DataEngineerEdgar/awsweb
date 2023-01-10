package com.awsweb.book.springboot.web;

import com.awsweb.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 1
public class HelloController {


    @GetMapping("/hello") // 2
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto") // REquestParam 외부 API로 넘긴 파라미터를 가져오는 어노테이션 -> 메소드파라미터로 저장
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}
