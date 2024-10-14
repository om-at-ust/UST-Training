package com.UST.SpringsecurityV3.service;

import com.UST.SpringsecurityV3.dto.UserInfoDTO;
import com.UST.SpringsecurityV3.entity.UserInfo;
import com.UST.SpringsecurityV3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public String addUser(UserInfoDTO userInfoDTO) {
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setUserName(userInfoDTO.getUsername());
        String pass = passwordEncoder.encode(userInfoDTO.getPassword());
        userInfo1.setPassword(pass);
        userInfo1.setEmail(userInfoDTO.getEmail());
        userRepository.save(userInfo1);
        return "user added to the system.";
    }
    public UserInfoDTO  getUserById(int id) {
        UserInfo userInfo = userRepository.findById(id).get();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUsername(userInfo.getUserName());
        userInfoDTO.setPassword(userInfo.getPassword());
        userInfoDTO.setEmail(userInfo.getEmail());
        return userInfoDTO;
    }
    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }



}
