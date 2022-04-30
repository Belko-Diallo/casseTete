package paysCapital;

import java.util.Objects;

public class Pays {
    String nom;
    String capital;

    public Pays(String n, String c) {
        this.nom = n;
        this.capital = c;
    }

    @Override
    public String toString() {
        return nom + " : " + capital + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pays)) return false;
        Pays pays = (Pays) o;
        return this.nom.equals(pays.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, capital);
    }
}
