package com.stevenbui.flashcode.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stevenbui.flashcode.models.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername ( String username );
}
