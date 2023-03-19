package ma.Bankati.jdbc;

import lombok.*;

import java.sql.*;

public class TestJBDC {



    public static void main(String[] args) {
        var url ="jdbc:mysql://localhost:3306/bankati" ;
        var login ="root";
        var pass ="";
        var driver ="com.mysql.cj.jdbc.Driver";
        Connection connection = null ;
         Statement statement = null;
        PreparedStatement sc = null;
        ResultSet resultSet = null;
        ResultSetMetaData resultMetaDta = null;

        try {
            Class.forName(driver);
            System.out.println("Driver loaded for mysql succefully");
            connection = DriverManager.getConnection(url, login, pass);
            System.out.println("Database connected with Bankkati database");

            //Statement
            sc=connection.prepareStatement("select * from Crédit ");
            resultSet = sc.executeQuery();
            resultMetaDta = resultSet.getMetaData();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            while (resultSet.next()){
                for (int i =1;i<=resultMetaDta.getColumnCount();i++)

                    System.out.print("\t"+resultMetaDta.getColumnName(i).toUpperCase()+
                            " : "+resultSet.getObject(i).toString() + "\t |");
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");


//                var id = resultSet.getLong("id");
//                var cp = resultSet.getDouble("capital");
//                var nbrMois = resultSet.getInt("nbr_mois");
//                var taux = resultSet.getDouble("taux_mensialité");
//                var demandeur = resultSet.getString("demandeur");
//                var mensualité = resultSet.getDouble("mensualité");
//
//                Crédit credit = new Crédit(id,cp,nbrMois,taux,demandeur,mensualité);
//                System.out.println(credit);

            }




        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("Database not connected");
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Database not closed");
                }
            }

        }
    }
}
