package com.huugoncalves.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huugoncalves.dsvendas.dto.SaleDTO;
import com.huugoncalves.dsvendas.dto.SaleSuccessDTO;
import com.huugoncalves.dsvendas.dto.SaleSumDTO;
import com.huugoncalves.dsvendas.entities.Sale;
import com.huugoncalves.dsvendas.repositories.SaleRepository;
import com.huugoncalves.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		// Armazenando vendedores na memória (Somente para este exemplo, pois possui
		// poucos vendedores)
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}

}
