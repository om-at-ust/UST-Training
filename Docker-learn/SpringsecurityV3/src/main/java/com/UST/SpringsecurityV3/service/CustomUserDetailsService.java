package com.UST.SpringsecurityV3.service;

import com.UST.SpringsecurityV3.entity.UserInfo;
import com.UST.SpringsecurityV3.entity.UserInfoDetails;
import com.UST.SpringsecurityV3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo =  userRepository.findByuserName(username);
        if(userInfo.isEmpty()){
            throw new UsernameNotFoundException("username "+username+"not found");
        }
        else
            return new UserInfoDetails(userInfo.get());
    }
}
