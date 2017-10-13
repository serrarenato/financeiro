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
import br.com.zup.entity.Price;
import br.com.zup.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	PriceService priceService;

	@RequestMapping("/list")
	public List<Price> listPrices() {

		List<Price> clientDetails = priceService.getPrices();
		return clientDetails;
	}
	

	
	@RequestMapping(value="/new",  method=RequestMethod.POST)
	public ResponseEntity newPrice(@RequestBody  Price price) {
		priceService.postPrice(price);
		return new ResponseEntity("ok", HttpStatus.OK);
	}

}
