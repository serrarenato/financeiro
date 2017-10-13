package br.com.zup.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.com.zup.entity.Greeting;


public interface GreetingRepository extends CrudRepository<Greeting,Long>{
	
		List<Greeting> findAll();
}
