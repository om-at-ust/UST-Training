package com.UST.SpringSecurtiyV2.services;

import com.UST.SpringSecurtiyV2.entity.UserDetailsImpl;
import com.UST.SpringSecurtiyV2.entity.UserInfo;
import com.UST.SpringSecurtiyV2.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserInfoRepository  userInfoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findByname(username);
        if(userInfo == null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new UserDetailsImpl(userInfo);
    }
}
