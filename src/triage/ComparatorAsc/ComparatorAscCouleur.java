package triage.ComparatorAsc;

import triage.Mobilier;

import java.util.Comparator;

public class ComparatorAscCouleur implements Comparator<Mobilier> {
    @Override
    public int compare(Mobilier o1, Mobilier o2) {
        return o1.couleur.compareToIgnoreCase(o2.couleur);
    }
}
