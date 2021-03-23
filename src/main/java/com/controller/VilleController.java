package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;


@RestController
public class VilleController {
	@Autowired
	private VilleBLO villeService;
	
	

	@RequestMapping(value ="/ville",method= RequestMethod.GET)
	@ResponseBody

	public List<Ville>  appelGet() {
		return villeService.getInfoVilles(null);
	}
}
