package ma.Bankati.modéle;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
    protected static long compteur = 1;
    protected Long id;
    protected String prenom, nom;
    protected String login, motDePasse, role;

    public String nomComplet() {
        return prenom + " " + nom;
    }



}
