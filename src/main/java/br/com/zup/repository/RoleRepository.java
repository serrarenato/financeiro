package br.com.zup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.entity.Role;


public interface RoleRepository extends CrudRepository<Role,Long>{
	
		List<Role> findAll();
}
