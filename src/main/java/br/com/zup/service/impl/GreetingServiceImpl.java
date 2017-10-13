package br.com.zup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.entity.Greeting;
import br.com.zup.repository.GreetingRepository;
import br.com.zup.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {
	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public List<Greeting> getGreeting() {
		return greetingRepository.findAll();
	}

	@Override
	public void postGreeting(Greeting greeting) {
		greetingRepository.save(greeting);		
	}
	@Override
	public Greeting postGreetingTest() {
		greetingRepository.save(new Greeting("Bauer"));
		greetingRepository.save(new Greeting("O'Brian"));
		greetingRepository.save(new Greeting("Bauer"));
		return null;
	}

}
