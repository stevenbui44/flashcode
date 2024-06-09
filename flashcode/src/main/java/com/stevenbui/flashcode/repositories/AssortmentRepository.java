package com.stevenbui.flashcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stevenbui.flashcode.models.Assortment;

public interface AssortmentRepository extends JpaRepository<Assortment, Long> {

}
