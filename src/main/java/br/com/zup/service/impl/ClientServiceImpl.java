package br.com.zup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.entity.Client;
import br.com.zup.repository.ClientRepository;
import br.com.zup.service.ClientService;
@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	@Override
	public void postClient(Client client) {
		clientRepository.save(client);
		
	}
	
	public Client getClientbyID(long id) {
		return clientRepository.findOne(id);
	}

}
