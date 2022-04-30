package triage.ComparatorAsc;

import triage.Mobilier;

import java.util.Comparator;

public class ComparatorAscElectronique implements Comparator<Mobilier> {
    @Override
    public int compare(Mobilier o1, Mobilier o2) {
        if (o1.electronique == o2.electronique) return 0;
        if (o1.electronique) return 1;
        return -1;
    }
}
