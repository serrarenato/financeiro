package br.com.zup.service;

import java.util.List;

import br.com.zup.entity.Price;

public interface PriceService {

	List<Price> getPrices();

	void postPrice(Price price);

	Price getPricebyID(long id);

}
