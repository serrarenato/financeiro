package br.com.zup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.entity.Contract;


public interface ContractRepository extends CrudRepository<Contract,Long>{
	
		List<Contract> findAll();
}
