package com.example.demo.service;

import com.example.demo.client.BitlyShortLinkClient;
import com.example.demo.dto.LinkRequestDto;
import com.example.demo.dto.LinkResponseDto;
import lombok.AllArgsConstructor;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.ShortenResponse;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LinkService {

    private final BitlyShortLinkClient bitlyShortLinkClient;

    public LinkResponseDto generate(LinkRequestDto linkRequestDto) {
        Response<ShortenResponse> response = bitlyShortLinkClient.callBitly(linkRequestDto.getLink());
        return new LinkResponseDto(response.data.url);

    }

}
