package com.example.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
public class TestController {

    public String hello() {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost")
                .path("/api/server/hello").encode().build().toUri();
        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return result;
    }

}
