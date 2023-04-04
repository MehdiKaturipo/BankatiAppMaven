package ma.Bankati.jdbc;

import javax.swing.*;
import java.sql.*;

public class Singleton {
    private static Connection connection= null;
    private  static  Singleton INSTANCE = null;
    private Singleton(){
        var url ="jdbc:mysql://localhost:3306/bankati" ;
        var login ="root";
        var pass ="";
        var driver ="com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, pass);
            JOptionPane.showMessageDialog(null,
                    "Connection établi avec success  ^_^ ",
                    "Session ouverte",
                    JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "ERREUR  DE CONNECION",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public static Singleton getInstance(){
        if(INSTANCE == null) INSTANCE = new Singleton();
        return INSTANCE;
    }
    public static Connection getConnection(){
        if(connection == null) getInstance();
        return connection;
    }
    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
                System.out.println("Fermeture de connection avec succés");
            } catch (SQLException e) {
                System.err.println("Fermeture de connection échoué");
            }
        }
    }

//    public static void main(String[] args) {
//        try {
//            PreparedStatement ps = getConnection().prepareStatement("select * from Crédit");
//            Statement st = getConnection().createStatement();
//                           getConnection().setAutoCommit(false);
//            DatabaseMetaData meta = getConnection().getMetaData();
//
//        }catch (SQLException e){
//           e.printStackTrace();
//        }
//    }

}
