package com.devsuperiorbootcamp.dsvendas.services;

import com.devsuperiorbootcamp.dsvendas.dto.SellerDTO;

import com.devsuperiorbootcamp.dsvendas.entities.Seller;
import com.devsuperiorbootcamp.dsvendas.repositories.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    private SellerRepository repository;

    public SellerService(SellerRepository repository) {
        this.repository = repository;
    }

    public List<SellerDTO> findAll(){
        //retorna uma lista de entidades seller
        List<Seller> result = repository.findAll();
        return result.stream().map(x -> new SellerDTO((x))).collect(Collectors.toList());
    }
}
