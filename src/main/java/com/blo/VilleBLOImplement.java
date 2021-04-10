package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;


@Service 
public class VilleBLOImplement implements VilleBLO {
	@Autowired
	private VilleDAO villeDao;
	
	@Override
	public	List<Ville> getInfoVilles(String param) {
		if(param==null) {
			return villeDao.nomVilles();
		}else {
			return villeDao.infoVilleParam(param);
		}
	}
	
	@Override
	public Ville ajouterVille(Ville ville) {
		return villeDao.ajouterVille(ville);
	}
}
