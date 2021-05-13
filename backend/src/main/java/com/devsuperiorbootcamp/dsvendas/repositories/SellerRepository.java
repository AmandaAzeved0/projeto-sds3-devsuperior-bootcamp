package com.devsuperiorbootcamp.dsvendas.repositories;

import com.devsuperiorbootcamp.dsvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
