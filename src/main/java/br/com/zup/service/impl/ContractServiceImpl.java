package br.com.zup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.entity.Client;
import br.com.zup.entity.Contract;
import br.com.zup.entity.LineofBusiness;
import br.com.zup.entity.Price;
import br.com.zup.repository.ContractRepository;
import br.com.zup.service.ClientService;
import br.com.zup.service.ContractService;
import br.com.zup.service.LineofBusinessService;
import br.com.zup.service.PriceService;

@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	ContractRepository contractRepository;
	@Autowired
	ClientService clientService;
	@Autowired
	LineofBusinessService lineofBusinessService;
	@Autowired
	PriceService priceService;

	@Override
	public List<Contract> getcontracts() {
		return contractRepository.findAll();
	}

	@Override
	public void postcontract(Contract contract) {
		Client client = clientService.getClientbyID(contract.getClient().getId());
		contract.setClient(client);
		Price price = priceService.getPricebyID(contract.getPrice().getId());
		contract.setPrice(price);
		LineofBusiness lineofBusiness = lineofBusinessService.getLineofBusinessbyID(contract.getLineofBusiness().getId());
		contract.setLineofBusiness(lineofBusiness);
		contractRepository.save(contract);

	}

}
