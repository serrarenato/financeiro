package br.com.zup.service;

import java.util.List;

import br.com.zup.entity.Greeting;

public interface GreetingService {

	public List<Greeting> getGreeting() ;
	public Greeting postGreetingTest() ;
	public void postGreeting(Greeting greeting);
}
