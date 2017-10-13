package br.com.zup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.entity.Greeting;
import br.com.zup.service.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	GreetingService greetingService;

	@RequestMapping("/listGreeting")
	public ResponseEntity greeting() {

		List<Greeting> greetingDetails = greetingService.getGreeting();
		return new ResponseEntity(greetingDetails, HttpStatus.OK);
	}
	
	@RequestMapping("/postTest")
	public ResponseEntity greetingPostTest() {
		greetingService.postGreetingTest();
		return new ResponseEntity("ok", HttpStatus.OK);
	}
	
	@RequestMapping(value="/postGreeting",  method=RequestMethod.POST)
	public ResponseEntity greetingPost(@RequestBody  Greeting greeting) {
		greetingService.postGreeting(greeting);
		return new ResponseEntity("ok", HttpStatus.OK);
	}

}
