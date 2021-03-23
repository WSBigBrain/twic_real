package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;


@Service
public class VilleBLOImplement implements VilleBLO {
	@Autowired
	private VilleDAO villeDao;
	
	
	@Autowired
	public VilleBLOImplement(final VilleDAO villeDAO) {
		this.villeDao=villeDAO;
	}
	
	
	@Override
	public	List<Ville> getInfoVilles(String param) {
		if(param.equals("")) {
			return villeDao.nomVilles();
		}else {
			return villeDao.infoVilleParam(param);
		}
	}
}
