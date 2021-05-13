package com.devsuperiorbootcamp.dsvendas.repositories;

import com.devsuperiorbootcamp.dsvendas.dto.SaleSuccessDTO;
import com.devsuperiorbootcamp.dsvendas.dto.SaleSumDTO;
import com.devsuperiorbootcamp.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    //retona o valor total de todas as vendas realizadas por um vendedor
    @Query("SELECT new com.devsuperiorbootcamp.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " +
            "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    //retorna o total de deals feitos pelo vendedor
    @Query("SELECT new com.devsuperiorbootcamp.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " +
            "FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();


}
