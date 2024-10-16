package com.UST.SpringsecurityV3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class UserInfoDTO {
    private String username;
    private String password;
    private String email;

    public UserInfoDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public UserInfoDTO() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
