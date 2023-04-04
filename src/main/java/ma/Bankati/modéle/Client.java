package ma.Bankati.modéle;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class Client extends Utilisateur{

    private String email, cin, tel;
    private Sexe sexe;
    private List<Compte> comptesClient = new ArrayList<>();


    @Override
    public String toString() {

        String      clientStr  = "------------------------------------------------------\n";
                    clientStr += "| Identifiant du Client     : "   + this.id        + "\n";
                    clientStr += "| Nom Complet               : "   + this.nomComplet() + "\n" ;
                    clientStr += "| Adresse email             : "   + this.email     + "\n" ;
                    clientStr += "| Numéro téléphone          : "   + this.tel       + "\n" ;
                    clientStr += "| Numéro de CIN             : "   + this.cin       + "\n" ;
                    clientStr += "| Sexe                      : "   + this.sexe      + "\n" ;
                    clientStr += "|-|-|-|-|- Informations de connexion " +"\n";
                    clientStr += "| Login                     : "   + this.login     + "\n" ;
                    clientStr += "| Mot de passe              : "   + this.motDePasse+ "\n" ;
                    clientStr += "| Role                      : "   + this.role      + "\n" ;
                    clientStr += "------------------------------------------------------\n";

        return clientStr;
    }


}
