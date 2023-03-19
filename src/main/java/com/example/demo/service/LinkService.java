package com.example.demo.service;

import com.example.demo.dto.LinkDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LinkService {

    public LinkDto generate(LinkDto linkDto) {
        linkDto.setLink("shortLink");
        return linkDto;
    }

}
