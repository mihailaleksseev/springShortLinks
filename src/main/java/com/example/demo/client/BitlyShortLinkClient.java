package com.example.demo.client;

import net.swisstech.bitly.BitlyClient;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.ShortenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class BitlyShortLinkClient {

    @Value("${app.bitly.accessToken}")
    private String ACCESS_TOKEN;

    public Response<ShortenResponse> callBitly(String longUrl) {
        BitlyClient client = new BitlyClient(ACCESS_TOKEN);
        return client.shorten()
                .setLongUrl(longUrl)
                .call();
    }

}
