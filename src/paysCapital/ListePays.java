package paysCapital;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class ListePays {
    List<Pays> listePays = new ArrayList<>();

    public ListePays(List<Pays> lesPays) {
        this.listePays = lesPays;
    }

    public boolean estVide(Pays p) {
        return this.listePays.isEmpty();
    }

    public boolean ajouter(Pays p) {
        return this.listePays.add(p);
    }

    public boolean retirer(Pays p) {
        return this.listePays.remove(p);
    }

    public boolean estDans(Pays p) {
        return this.listePays.contains(p);
    }
}
