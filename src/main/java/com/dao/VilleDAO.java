package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class VilleDAO {
	
	@Autowired
	private DaoFactory daoFactory;
	
	
	VilleDAO(DaoFactory daoFactory){
		this.daoFactory=daoFactory;
	}
	
	
	public List<String> nomVilles(){
		List<String> villes = new ArrayList<String>();
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
            	villes.add(resultat.getString(2));
            }
        }catch (SQLException e){
        	e.printStackTrace();
        	
        }
        return villes;
        
	}
	
	public List<String> infoVilleParam(String param){
		List<String> villes = new ArrayList<String>();
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
            	villes.add(resultat.getString(2));
            }
        }catch (SQLException e){
        	e.printStackTrace();
        	
        }
        return villes;
        
	}
	
}
