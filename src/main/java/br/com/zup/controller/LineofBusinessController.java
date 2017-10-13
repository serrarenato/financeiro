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
import br.com.zup.entity.LineofBusiness;
import br.com.zup.service.LineofBusinessService;

@RestController
@RequestMapping("/lineofBusiness")
public class LineofBusinessController {

	@Autowired
	LineofBusinessService lineofBusinessService;

	@RequestMapping("/list")
	public List<LineofBusiness> listLOB() {

		List<LineofBusiness> lineofBusinessDetails = lineofBusinessService.getLineofBusiness();
		return lineofBusinessDetails;
	}
	

	
	@RequestMapping(value="/new",  method=RequestMethod.POST)
	public ResponseEntity newLOB(@RequestBody  LineofBusiness lineofBusiness) {
		lineofBusinessService.postLineofBusiness(lineofBusiness);
		return new ResponseEntity("ok", HttpStatus.OK);
	}

}
