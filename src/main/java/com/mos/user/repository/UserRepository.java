package com.mos.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mos.user.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

   User findByUserId( Long userId );
}
