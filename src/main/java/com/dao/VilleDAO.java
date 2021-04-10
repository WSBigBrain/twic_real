package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dto.Coordonnees;
import com.dto.Ville;
import java.sql.PreparedStatement;
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
            	villes.add(new Ville(resultat.getString(2),resultat.getString(3),new Coordonnees(resultat.getString(7),resultat.getString(6)),resultat.getString(1),resultat.getString(4),resultat.getString(5)));
            }
        }catch (SQLException e){
        	e.printStackTrace();
        	
        }
        return villes;
        
	}
	
	public List<Ville> infoVilleParam(String param){
		List<Ville> villes = new ArrayList<Ville>();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;
        
        
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("SELECT "
            		+ "* "
            		+ "FROM "
            		+ "ville_france WHERE Code_postal = ?");
            statement.setString(1, param);
            resultat=statement.executeQuery();

            while (resultat.next()) {
            	villes.add(new Ville(resultat.getString(2),resultat.getString(3),new Coordonnees(resultat.getString(7),resultat.getString(6)),resultat.getString(1),resultat.getString(4),resultat.getString(5)));
            }
        }catch (SQLException e){
        	e.printStackTrace();
        	
        }
        return villes;
        
	}
	
	public Ville ajouterVille(Ville ville) {
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        
        
        try {
            connexion = daoFactory.getConnection();
            PreparedStatement prepared  = connexion.prepareStatement("INSERT INTO ville_france (Code_commune_INSEE,Nom_commune,Code_postal,Libelle_acheminement,Ligne_5,Latitude,Longitude)"
            		+ "VALUES ( ? , ? , ? , ? , ? , ? , ? )" );
            prepared.setString(1, ville.getCodeInsee());
            prepared.setString(2, ville.getNom());
            prepared.setString(3, ville.getCodePostal());
            prepared.setString(4, ville.getLibelle());
            prepared.setString(5, ville.getLigne5());
            prepared.setString(6, ville.getCoordonnees().getLatitude());
            prepared.setString(7, ville.getCoordonnees().getLongitude());
            prepared.executeUpdate();
            

        }catch (SQLException e){
        	e.printStackTrace();
        	
        }
        return ville;
		
	}
	
}
