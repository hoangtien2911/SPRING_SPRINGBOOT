package com.codeusingjava.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {

    @GetMapping("user")
    public String getUser(final Principal user) {
    	Map<String, Object> mp= (Map<String, Object>) ((OAuth2Authentication) user).getUserAuthentication().getDetails();
        
    	String username= (String) mp.get("name");
    	
    	 return "Welcome "+username;
    }
}


//#security:
//#  oauth2:
//#    client:
//#       clientId: 37c17a4b82859c802bd8
//#       clientSecret: 8eaa2a9ea38de9adec1a5eeee8ea5072d2322c4c
//#       accessTokenUri: https://github.com/login/oauth/access_token
//#       userAuthorizationUri: https://github.com/login/oauth/authorize
//#       clientAuthenticationScheme: form
//#    resource:
//#      user-info-uri: https://api.github.com/user
//#      prefer-token-info: false        
//#         
//#
//     