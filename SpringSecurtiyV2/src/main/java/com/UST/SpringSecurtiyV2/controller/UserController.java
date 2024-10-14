package com.UST.SpringSecurtiyV2.controller;

import com.UST.SpringSecurtiyV2.dto.UserInfoDto;
import com.UST.SpringSecurtiyV2.entity.JobInfo;
import com.UST.SpringSecurtiyV2.entity.UserInfo;
import com.UST.SpringSecurtiyV2.services.JobInfoService;
import com.UST.SpringSecurtiyV2.services.UserInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
//http://localhost:9095/api/v1/
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private JobInfoService jobInfoService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    public String index() {
        return "Welcome to index page";
    }
//    @GetMapping("/home")
//    @PreAuthorize("hasRole(`USER`)")
//    public String home(HttpServletRequest request){
//        return "Welcome to home page your sessionId is: "+ request.getSession().getId();
//    }
//
//    @GetMapping()
//    public String index(HttpServletRequest request){
//        return "Welcome to index page your sessionId is: "+ request.getSession().getId() + "Go to /home or /admin";
//    }
//
//    @GetMapping("/admin")
//    @PreAuthorize("hasAuthority(`ROLE_ADMIN`)")
//    public String admin(HttpServletRequest request){
//        return "Welcome to admin page your sessionId is: "+ request.getSession().getId();
//    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo user){
        return  userInfoService.addUser(user);

    }

    @PostMapping("/addJob")
    public String addJob(@RequestBody JobInfo job){
        jobInfoService.addJobInfo(job);
        return "Job added";
    }
    @GetMapping("/getAllJobs")
    public List<JobInfo> getAllJobs(){
        return jobInfoService.getAllJobInfo();
    }
    @GetMapping("/getAllUsers")
    public List<UserInfo> getAllUsers(){
        return userInfoService.getAllUser();
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody User user){
        return "Authenticated";
    }

    @GetMapping("/login")
    public String userLogin(UserInfoDto user){
        String userName = user.getUsername();
        String password = user.getPassword();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        if(authentication.isAuthenticated()){
            return "Login successful";
        }else{
            return "Login failed";
        }
    }





}
