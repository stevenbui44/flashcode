package com.stevenbui.flashcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stevenbui.flashcode.models.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername ( String username );
}
