package com.UST.SpringSecurtiyV2.services;


import com.UST.SpringSecurtiyV2.entity.UserInfo;
import com.UST.SpringSecurtiyV2.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired(required = true)
    public UserInfoRepository userInfoRepository;

    public List<UserInfo> getAllUser() {
        return userInfoRepository.findAll();
    }

    public String addUser(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
        return "user added to the system";
    }
}
