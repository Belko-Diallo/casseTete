package recherche.sort;

import recherche.Departement;

import java.util.Comparator;

public class ComparatorChefLieu implements Comparator<Departement> {
    @Override
    public int compare(Departement o1, Departement o2) {
        return o1.chefLieu.compareTo(o2.chefLieu);
    }
}
