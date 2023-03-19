package com.example.demo.controller;


import com.example.demo.dto.LinkRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LinkControllerTest extends BaseControllerTest {

    private static final String LINK_ENDPOINT = "/api/v1/link";

//    todo для корректной работы теста необходимо реализовать мок клиена bitly для профиля тест
//     или убедиться что ссылка не удаляется из bitly
    @Test
    void getDemoTest() throws Exception {
        LinkRequestDto linkRequestDto = new LinkRequestDto();
        linkRequestDto.setLink("https://mvnrepository.com/artifact/net.swisstech/bitly-api-client?repo=springio-plugins-release");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(LINK_ENDPOINT)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content(mapper.writeValueAsString(linkRequestDto));

        mvc.perform(requestBuilder)
                .andExpect(jsonPath("$.link").value("bit.ly/42qq7o4"))
                .andExpect(status().isOk());
    }

}
