package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Utilisateur;
import config.DbConnection;

public class UtilisateurDao {
    private static final String SELECT_ALL_USERS = "SELECT * FROM utilisateur";
    private static final String INSERT_USER = "INSERT INTO utilisateur ( nom, prenom, login, password,mail,lieuNaissance,dateNaissance,telephone,image,sexe) VALUES ( ?, ?, ?, ?,?,?,?,?,?,?)";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM utilisateur WHERE id = ?";
    private static final String UPDATE_USER = "UPDATE utilisateur SET nom = ?, prenom =? , login = ? , password = ?, mail = ?, lieuNaissance =?,dateNaissance =?, telephone = ?, image = ?, sexe = ? WHERE id = ?";
    private static final String DELETE_USER = "DELETE FROM utilisateur WHERE id = ?";

    public static ArrayList<Utilisateur> lister() {
        ArrayList<Utilisateur> listUser = new ArrayList<>();
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setLogin(resultSet.getString("login"));
                utilisateur.setPassword(resultSet.getString("password"));
                utilisateur.setLieuNaissance(resultSet.getString("lieuNaissance"));
                utilisateur.setDateNaissance(resultSet.getDate("dateNaissance"));
                utilisateur.setTelephone(resultSet.getString("telephone"));
                utilisateur.setSexe(resultSet.getString("sexe"));
                utilisateur.setMail(resultSet.getString("mail"));
                utilisateur.setImage(resultSet.getString("image"));

                listUser.add(utilisateur);
                System.out.println(utilisateur.getLogin());
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }
        return listUser;
    }

    public static void addUser(Utilisateur utilisateur) {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getLogin());
            preparedStatement.setString(4, utilisateur.getPassword());
            preparedStatement.setString(5, utilisateur.getMail());
            preparedStatement.setString(6, utilisateur.getLieuNaissance());
            preparedStatement.setDate(7, (Date) utilisateur.getDateNaissance());
            preparedStatement.setString(8, utilisateur.getTelephone());
            preparedStatement.setString(9, utilisateur.getImage());
            preparedStatement.setString(10, utilisateur.getSexe());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Utilisateur findUser(int id) {
        Utilisateur utilisateur = null;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    utilisateur = new Utilisateur();
                    utilisateur.setId(resultSet.getInt("id"));
                    utilisateur.setNom(resultSet.getString("nom"));
                    utilisateur.setPrenom(resultSet.getString("prenom"));
                    utilisateur.setLogin(resultSet.getString("login"));
                    utilisateur.setPassword(resultSet.getString("password"));
                    utilisateur.setLieuNaissance(resultSet.getString("lieuNaissance"));
                    utilisateur.setDateNaissance(resultSet.getDate("dateNaissance"));
                    utilisateur.setTelephone(resultSet.getString("telephone"));
                    utilisateur.setSexe(resultSet.getString("sexe"));
                    utilisateur.setMail(resultSet.getString("mail"));
                    utilisateur.setImage(resultSet.getString("image"));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    public static void updateUser(Utilisateur utilisateur) {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());
            preparedStatement.setString(3, utilisateur.getLogin());
            preparedStatement.setString(4, utilisateur.getPassword());
            preparedStatement.setString(5, utilisateur.getMail());
            preparedStatement.setString(6, utilisateur.getLieuNaissance());
            preparedStatement.setDate(7, (Date) utilisateur.getDateNaissance());
            preparedStatement.setString(8, utilisateur.getTelephone());
            preparedStatement.setString(9, utilisateur.getImage());
            preparedStatement.setString(10, utilisateur.getSexe());
            preparedStatement.setInt(11, utilisateur.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int id) {
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
