package br.com.zup.service;

import java.util.List;

import br.com.zup.entity.Client;

public interface ClientService {

	List<Client> getClients();

	void postClient(Client client);

	public Client getClientbyID(long id);

}
