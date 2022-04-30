package recherche.sort;

import recherche.Departement;

import java.util.Comparator;

public class ComparatorNomDepart implements Comparator<Departement> {
    @Override
    public int compare(Departement o1, Departement o2) {
        return o1.nomDepart.compareTo(o2.nomDepart);
    }
}
