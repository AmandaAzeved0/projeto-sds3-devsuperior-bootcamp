package com.devsuperiorbootcamp.dsvendas.services;

import com.devsuperiorbootcamp.dsvendas.dto.SaleDTO;
import com.devsuperiorbootcamp.dsvendas.entities.Sale;
import com.devsuperiorbootcamp.dsvendas.repositories.SaleRepository;
import com.devsuperiorbootcamp.dsvendas.repositories.SellerRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SaleService {

    private SaleRepository repository;
    private SellerRepository sellerrepository;

    public SaleService(SaleRepository repository, SellerRepository sellerrepository) {
        this.repository = repository;
        this.sellerrepository = sellerrepository;
    }

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable){

        //a JPA busca todos os vendedores e armazena em cache.
        // Coerente por ser um numero pequeno de vendedores
        sellerrepository.findAll();

        //retorna uma lista de entidades sale
        Page<Sale> result = repository.findAll(pageable);

        //converte cada item (x) dessa lista de sellers para uma lista d
        return result.map(x -> new SaleDTO((x)));

        //alternativa method reference : return result.stream().map(SellerDTO::new).collect(Collectors.toList());
    }
}
