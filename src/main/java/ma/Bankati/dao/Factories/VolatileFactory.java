package ma.Bankati.dao.Factories;

import ma.Bankati.dao.IDao;
import ma.Bankati.modéle.Crédit;

public class VolatileFactory extends Factory{
    @Override
    public IDao<Crédit, Long> getCréditDao() {
        return null;
    }
}
