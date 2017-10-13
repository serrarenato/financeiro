package br.com.zup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.entity.Client;
import br.com.zup.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@RequestMapping("/list")
	public List<Client> listClient() {

		List<Client> clientDetails = clientService.getClients();
		return clientDetails;
	}
	

	
	@RequestMapping(value="/new",  method=RequestMethod.POST)
	public ResponseEntity newClient(@RequestBody  Client client) {
		clientService.postClient(client);
		return new ResponseEntity("ok", HttpStatus.OK);
	}

}
