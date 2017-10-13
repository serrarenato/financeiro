package br.com.zup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.entity.Price;
import br.com.zup.repository.PriceRepository;
import br.com.zup.service.PriceService;
@Service
public class PriceServiceImpl implements PriceService{
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Override
	public List<Price> getPrices() {
		return priceRepository.findAll();
	}

	@Override
	public void postPrice(Price price) {
		priceRepository.save(price);
		
	}

	@Override
	public Price getPricebyID(long id) {
		return priceRepository.findOne(id);
	}

}
