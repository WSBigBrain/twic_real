package com.blo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
			try {
				return villeDao.nomVilles();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				return villeDao.infoVilleParam(param);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public Ville ajouterVille(Ville ville) {
		try {
			return villeDao.ajouterVille(ville);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ville;
	}
}
