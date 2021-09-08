package com.huugoncalves.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huugoncalves.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
