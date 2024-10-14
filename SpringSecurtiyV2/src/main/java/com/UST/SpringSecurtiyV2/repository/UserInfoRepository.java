package com.UST.SpringSecurtiyV2.repository;

import com.UST.SpringSecurtiyV2.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends MongoRepository<UserInfo, Integer>{
    UserInfo findByname(String username);
}
