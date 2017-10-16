package com.ranstats.ui.web;

import com.ranstats.ui.config.StravaConfig;
import javastrava.auth.AuthorisationService;
import javastrava.auth.impl.AuthorisationServiceImpl;
import javastrava.auth.model.Token;
import javastrava.model.StravaAthlete;
import javastrava.service.Strava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiController {

    @Autowired
    public StravaConfig config;

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public String GetToken(@RequestParam("state") String state, @RequestParam("code") String code) {


        AuthorisationService service = new AuthorisationServiceImpl();
        Token token = service.tokenExchange(config.client_id, config.client_secret, code);

        Strava strava = new Strava(token);

        StravaAthlete athlete = strava.getAuthenticatedAthlete();

        return "OK";
    }

}
