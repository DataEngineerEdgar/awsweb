package com.awsweb.book.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)

public class HelloControllerTest {
    @Autowired
    private MockMvc mvc; // 웹 API 테스트할 때 사용, 스프링 MVC 테스트의 시작점 , HTTP GET과 POST 등에 대한 API테스트 가능

    @Test
    public void return_to_hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))     // MockMvc를 통해 hello 주소로 GET 요청을 함 , 체이닝이 지원되어 여러 검증 기능을 이어 선언 가능
                .andExpect(status().isOk())  // mvc.perform 의 결과를 검증함 / HTTP heead 의 Status를 검증 404 500 등 검증, IsOK는 200 OK 검증
                .andExpect(content().string(hello)); // mvc.perform 의 결과를 검증 함 , 응담 본분 내용 검증 , hello 내용이 맞는 지 검증
    }

    @Test
    public void return_to_helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


    }
}
