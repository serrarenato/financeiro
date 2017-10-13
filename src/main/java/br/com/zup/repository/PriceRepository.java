package br.com.zup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.entity.Price;


public interface PriceRepository extends CrudRepository<Price,Long>{
	
		List<Price> findAll();
}
