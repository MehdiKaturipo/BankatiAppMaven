package ma.Bankati.modéle;

public class Admin extends Utilisateur{

    private static  Admin ADMIN = new Admin();

    private Admin(){

        login       = "admin";
        motDePasse  = "1234";
        role        = "Admin";
        nom         =  "Soussan";
        prenom      = "Mehdi";

    }


    public static Admin getInstance(){

        return ADMIN;
    }

}
