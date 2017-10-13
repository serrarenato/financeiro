package br.com.zup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.entity.Client;


public interface ClientRepository extends CrudRepository<Client,Long>{
	
		List<Client> findAll();
}
