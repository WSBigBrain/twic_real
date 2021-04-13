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
	private DaoFactory daoFactory;

	public List<Ville> nomVilles() throws SQLException {
		List<Ville> villes = new ArrayList<Ville>();
		Connection connexion = null;
		ResultSet resultat = null;
		Statement statement=null;

		try  {
			
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT " + "* " + "FROM " + "ville_france;");
			while (resultat.next()) {
				villes.add(new Ville(resultat.getString(2), resultat.getString(3),
						new Coordonnees(resultat.getString(7), resultat.getString(6)), resultat.getString(1),
						resultat.getString(4), resultat.getString(5)));
			}
			
		}finally {
			statement.close();
			resultat.close();
		}
		return villes;

	}

	public List<Ville> infoVilleParam(String param) throws SQLException {
		List<Ville> villes = new ArrayList<Ville>();
		Connection connexion = null;
		PreparedStatement statement = null;
		ResultSet resultat = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.prepareStatement("SELECT " + "* " + "FROM " + "ville_france WHERE Code_postal = ?");
			statement.setString(1, param);
			resultat = statement.executeQuery();

			while (resultat.next()) {
				villes.add(new Ville(resultat.getString(2), resultat.getString(3),
						new Coordonnees(resultat.getString(7), resultat.getString(6)), resultat.getString(1),
						resultat.getString(4), resultat.getString(5)));

			}

		} finally {
			statement.close();
			resultat.close();
		}

		return villes;

	}

	public Ville ajouterVille(Ville ville) throws SQLException {
		Connection connexion = null;
		PreparedStatement prepared = null;

		try {
			connexion = daoFactory.getConnection();
			prepared = connexion.prepareStatement(
					"INSERT INTO ville_france (Code_commune_INSEE,Nom_commune,Code_postal,Libelle_acheminement,Ligne_5,Latitude,Longitude)"
							+ "VALUES ( ? , ? , ? , ? , ? , ? , ? )");
			prepared.setString(1, ville.getCodeInsee());
			prepared.setString(2, ville.getNom());
			prepared.setString(3, ville.getCodePostal());
			prepared.setString(4, ville.getLibelle());
			prepared.setString(5, ville.getLigne5());
			prepared.setString(6, ville.getCoordonnees().getLatitude());
			prepared.setString(7, ville.getCoordonnees().getLongitude());
			prepared.executeUpdate();

		} finally {
			prepared.close();
		}
		return ville;

	}

}
