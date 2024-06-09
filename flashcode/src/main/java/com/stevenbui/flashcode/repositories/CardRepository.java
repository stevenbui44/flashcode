package com.stevenbui.flashcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stevenbui.flashcode.models.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}
