package com.UST.user.repository;

import com.UST.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByaccountNumber(Long accountNumber);
}
