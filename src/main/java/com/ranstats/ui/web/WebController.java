package com.ranstats.ui.web;

import com.ranstats.ui.config.StravaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Controller
public class WebController {

    @Autowired
    public StravaConfig config;


    @GetMapping("/")
    public String Get(Map<String, Object> model) {
        model.put("strava_url", config.oauth_authorize_url);
        model.put("client_id", config.client_id);
        model.put("client_secret", config.client_secret);

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
        URI newUri = builder.build().toUri();

        String host = newUri.getHost();


        if (newUri.getPort() != 80) {
            host += ":" + ((Integer)newUri.getPort()).toString();
        }

        model.put("host", host);
        return "welcome";
    }


}