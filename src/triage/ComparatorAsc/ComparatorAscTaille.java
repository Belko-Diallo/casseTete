package triage.ComparatorAsc;

import triage.Mobilier;

import java.util.Comparator;

public class ComparatorAscTaille implements Comparator<Mobilier> {
    @Override
    public int compare(Mobilier o1, Mobilier o2) {
        String m = "Normal";
        String g = "Grand";
        String m1 = o1.taille;
        String m2 = o2.taille;
        if (m1.equals(m2)) return 0;
        if (m1.equals(g)) return 1;
        if (m2.equals(g)) return -1;
        if (m1.equals(m)) return 1;
        return -1;
    }
}
