package br.com.zup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.entity.Contract;
import br.com.zup.service.ContractService;

@RestController
@RequestMapping("/contract")
public class ContractController {

	@Autowired
	ContractService contractService;

	@RequestMapping("/list")
	public List<Contract> listContracts() {

		List<Contract> clientDetails = contractService.getcontracts();
		return clientDetails;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity newContract(@RequestBody Contract contract) {
		
		contractService.postcontract(contract);
		return new ResponseEntity("ok", HttpStatus.OK);
	}

}
