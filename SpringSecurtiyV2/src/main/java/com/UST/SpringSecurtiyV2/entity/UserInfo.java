package com.UST.SpringSecurtiyV2.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Document(collection = "userInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    private int id;
    private String name;
    private String email;
    private String password;
    private List<GrantedAuthority> authoritiesList;

}
