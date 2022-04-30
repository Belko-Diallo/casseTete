package triage.ComparatorDesc;

import triage.Mobilier;

import java.util.Comparator;

public class ComparatorDescQuantite implements Comparator<Mobilier> {
    @Override
    public int compare(Mobilier o1, Mobilier o2) {
        return o2.quantite.compareTo(o1.quantite);
    }
}
