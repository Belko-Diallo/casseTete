package recherche.sort;

import recherche.Departement;

import java.util.Comparator;

public class ComparatorCodeRegion implements Comparator<Departement> {
    @Override
    public int compare(Departement o1, Departement o2) {
        return o1.codeRegion.compareTo(o2.codeRegion);
    }
}
