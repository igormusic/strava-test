package com.ranstats.ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StravaConfig {

    @Value("${strava_client_id}")
    public Integer client_id;

    @Value("${strava_client_secret}")
    public String client_secret;

    @Value("${strava.oauth_authorize_url}")
    public String oauth_authorize_url;

    @Value("${strava.oauth_token_url}")
    public String oauth_token_url;

}
