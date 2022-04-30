package triage.ComparatorDesc;

import triage.Mobilier;

import java.util.Comparator;

public class ComparatorDescPrix implements Comparator<Mobilier> {
    @Override
    public int compare(Mobilier o1, Mobilier o2) {
        return o2.prix.compareTo(o1.prix);
    }
}
