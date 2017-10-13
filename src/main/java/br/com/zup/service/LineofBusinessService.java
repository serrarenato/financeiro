package br.com.zup.service;

import java.util.List;

import br.com.zup.entity.LineofBusiness;

public interface LineofBusinessService {

	List<LineofBusiness> getLineofBusiness();

	void postLineofBusiness(LineofBusiness lineofBusiness);

	LineofBusiness getLineofBusinessbyID(long id);

}
