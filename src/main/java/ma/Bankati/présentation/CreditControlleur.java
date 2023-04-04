package ma.Bankati.présentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.Bankati.métier.IMétierCrédit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Data @AllArgsConstructor @NoArgsConstructor
@Controller
public class CreditControlleur implements ICréditControlleur {
    @Autowired
    @Qualifier("métier")
    IMétierCrédit métierCrédit;
    @Override
    public void afficherMensualité(Long idCrédit) throws Exception {
        var creditAvecMensualité = métierCrédit.calculerMensualité(idCrédit);
        System.out.println(creditAvecMensualité);
    }
}
