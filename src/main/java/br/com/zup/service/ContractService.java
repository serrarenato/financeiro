package br.com.zup.service;

import java.util.List;

import br.com.zup.entity.Contract;

public interface ContractService {

	List<Contract> getcontracts();

	void postcontract(Contract contract);

}
