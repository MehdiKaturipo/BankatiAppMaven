package ma.Bankati.jdbc;

import lombok.*;
import ma.Bankati.modéle.Client;
import ma.Bankati.modéle.Crédit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class TestJBDC {



    public static void main(String[] args) throws IOException {
//        var url ="jdbc:mysql://localhost:3306/bankati" ;
//        var login ="root";
//        var pass ="";
//        var driver ="com.mysql.cj.jdbc.Driver";
        Connection connection = Singleton.getConnection() ;
        var crédit = new ArrayList<Crédit>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream config = classLoader.getResourceAsStream("config/application.properties");
            if (config == null) throw new IOException("config.properties not found");
            var properties = new Properties();
            properties.load(config);
            var url = properties.getProperty("URL");
            var login = properties.getProperty("USERNAME");
            var pass = properties.getProperty("PASSWORD");
            connection = DriverManager.getConnection(url, login, pass);
            System.out.println("Connection établi avec success  ^_^ ");

            var  statement = connection.createStatement();
            var resultSet = statement.executeQuery("select * from Crédit ");

            while (resultSet.next()){
                            var id =   resultSet.getLong("id");
                            var capitale_Emprunté = resultSet.getDouble("capitale_Emprunté");
                            var nombreDeMois = resultSet.getInt("nombreDeMois");
                            var taux_Mensuel = resultSet.getDouble("taux_Mensuel");
                            var demandeur = resultSet.getString("Demandeur");
                            var mensualité = resultSet.getDouble("mensualité");
                             crédit.add(new Crédit(id,capitale_Emprunté,nombreDeMois,taux_Mensuel,demandeur,mensualité));

                    }

            // METHODE 1
//            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
//            while (resultSet.next()){
//                for (int i =1;i<=resultMetaDta.getColumnCount();i++)
//
//                    System.out.print("\t"+resultMetaDta.getColumnName(i).toUpperCase()+
//                            " : "+resultSet.getObject(i).toString() + "\t |");
//                System.out.println();
//                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
//
//            }
            // METHODE 2
//            while (resultSet.next()){
//
//                System.out.println("=========================================================");
//                System.out.println("                        CREDITs                          ");
//                System.out.println("=========================================================");
//                System.out.println("#ID        :   "+ resultSet.getInt("id"));
//                System.out.println("+OWNER     :   "+ resultSet.getString("Demandeur"));
//                System.out.println("-AMOUNT    :   "+ resultSet.getDouble("capitale_Emprunté")+ " DHs");
//                System.out.println("-DURATION  :   "+ resultSet.getInt("nombreDeMois")+" Months");
//                System.out.println("-RATE      :   "+ resultSet.getDouble("taux_Mensuel")+" %");
//                System.out.println("-DHs/Month :   "+ resultSet.getDouble("mensualité")+" DHs");
//                System.out.println("=========================================================");
//
//            }
         if (crédit.isEmpty()) System.out.println("Aucun crédit trouvé");
         else crédit.forEach(System.out::println);



        } catch (IOException e) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("Connection échoué");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Fermeture de sesssion établi avec success  ^_^");
                } catch (SQLException e) {
                    System.err.println("Fermeture de sesssion échoué");
                }
                Singleton.closeConnection();
            }

        }
    }
}
