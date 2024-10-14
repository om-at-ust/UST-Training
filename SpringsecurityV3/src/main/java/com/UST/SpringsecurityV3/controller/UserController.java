package com.UST.SpringsecurityV3.controller;

import com.UST.SpringsecurityV3.dto.UserInfoDTO;
import com.UST.SpringsecurityV3.entity.UserInfo;
import com.UST.SpringsecurityV3.service.JWTService;
import com.UST.SpringsecurityV3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;

    @PostMapping ("/register")
    public String addUser(@RequestBody UserInfoDTO userInfoDTO){
        return userService.addUser(userInfoDTO);
    }
    @PostMapping("/validate/user")
    public String login(@RequestBody UserInfoDTO userInfoDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userInfoDTO.getUsername(),userInfoDTO.getPassword()));
        System.out.println("authenticated ?? : " + authentication.isAuthenticated());
        if(authentication.isAuthenticated())
        {
           return jwtService.generateToken(userInfoDTO.getUsername());
        }
        return "Failed to authenticate";
    }
    @GetMapping("/getAllUsers")
    public List<UserInfo> getAllUsers(){
        return userService.getAllUsers();
    }



}
