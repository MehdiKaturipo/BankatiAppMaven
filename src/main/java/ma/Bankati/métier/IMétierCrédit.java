package ma.Bankati.métier;

import ma.Bankati.modéle.Crédit;

public interface IMétierCrédit {
    Crédit calculerMensualité(Long idCrédit) throws Exception;
}
