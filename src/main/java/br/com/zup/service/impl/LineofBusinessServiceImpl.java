package br.com.zup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.entity.LineofBusiness;
import br.com.zup.repository.LineofBusinessRepository;
import br.com.zup.service.LineofBusinessService;
@Service
public class LineofBusinessServiceImpl implements LineofBusinessService{
	
	@Autowired
	private LineofBusinessRepository lineofBusinessRepository;
	
	@Override
	public List<LineofBusiness> getLineofBusiness() {
		return lineofBusinessRepository.findAll();
	}

	@Override
	public void postLineofBusiness(LineofBusiness lineofBusiness) {
		lineofBusinessRepository.save(lineofBusiness);
		
	}

	@Override
	public LineofBusiness getLineofBusinessbyID(long id) {
		return lineofBusinessRepository.findOne(id);
	}

}
