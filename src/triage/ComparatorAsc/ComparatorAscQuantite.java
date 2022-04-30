package triage.ComparatorAsc;

import triage.Mobilier;

import java.util.Comparator;

public class ComparatorAscQuantite implements Comparator<Mobilier> {
    @Override
    public int compare(Mobilier o1, Mobilier o2) {
        return o1.quantite.compareTo(o2.quantite);
    }
}
