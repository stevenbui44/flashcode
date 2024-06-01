package com.stevenbui.flashcode.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.stevenbui.flashcode.models.Assortment;
import com.stevenbui.flashcode.repositories.AssortmentRepository;

@Component
public class AssortmentService extends Service {

    private final AssortmentRepository assortmentRepository;

    public AssortmentService ( final AssortmentRepository assortmentRepository ) {
        super();
        this.assortmentRepository = assortmentRepository;
    }

    @Override
    protected JpaRepository<Assortment, Long> getRepository () {
        return assortmentRepository;
    }

}
