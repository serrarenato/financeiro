package br.com.zup.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.entity.ApplicationUser;
import br.com.zup.entity.Client;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
	ApplicationUser findByUsername(String username);
	List<ApplicationUser> findAll();
}
