package br.com.zup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.entity.LineofBusiness;


public interface LineofBusinessRepository extends CrudRepository<LineofBusiness,Long>{
	
		List<LineofBusiness> findAll();
}
