package com.tm.repository;

import com.tm.entities.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<userEntity, Long> {

    userEntity findByEmail(String email);
}
