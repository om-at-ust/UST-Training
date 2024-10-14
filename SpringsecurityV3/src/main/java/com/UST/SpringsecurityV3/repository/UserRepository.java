package com.UST.SpringsecurityV3.repository;

import com.UST.SpringsecurityV3.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByuserName(String username);
}
