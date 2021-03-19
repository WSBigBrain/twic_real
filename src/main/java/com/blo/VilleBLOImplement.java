package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.VilleDAO;



public class VilleBLOImplement implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDao;
	
	
	public	List<String> getInfoVilles(String param) {
		if(param.equals("")) {
			return villeDao.nomVilles();
		}else {
			return villeDao.infoVilleParam(param);
		}
	}
}
