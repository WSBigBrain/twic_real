package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dto.Ville;
@Component
public class VilleDAO {
	@Autowired
	private  DaoFactory daoFactory;
	
	
	
	public List<Ville> nomVilles(){
		List<Ville> villes = new ArrayList<Ville>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT "
            		+ "* "
            		+ "FROM "
            		+ "ville_france;");

            while (resultat.next()) {
            	villes.add(new Ville(resultat.getString(2),resultat.getString(3)));
            }
        }catch (SQLException e){
        	e.printStackTrace();
        	
        }
        return villes;
        
	}
	
	public List<Ville> infoVilleParam(String param){
		List<Ville> villes = new ArrayList<Ville>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT "
            		+ "* "
            		+ "FROM "
            		+ "ville_france WHERE codePostal ="+param+ ";");

            while (resultat.next()) {
            	villes.add(new Ville(resultat.getString(2),resultat.getString(3)));
            }
        }catch (SQLException e){
        	e.printStackTrace();
        	
        }
        return villes;
        
	}
	
}
