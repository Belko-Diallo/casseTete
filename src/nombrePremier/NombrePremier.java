package nombrePremier;

import java.util.ArrayList;

public class NombrePremier {
    private ArrayList<Integer> lesNombresPremiers = new ArrayList<>();

    public NombrePremier(int nombre) {
        if (nombre < 0) {
            throw new NumberFormatException("Les nombres premiers ne peuvent pas être néatifs !");
        }
        lesNombresPremiers.add(1);
        lesNombresPremiers.add(2);
        boolean ajoutable = true;
        for (int i = 3; i <= nombre; i++) {
            for (int contenu : lesNombresPremiers) {
                if (i % contenu == 0 && contenu != 1) {
                    ajoutable = false;
                    break;
                }
            }
            if (ajoutable) {
                lesNombresPremiers.add(i);
            }
            ajoutable = true;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int contenu : this.lesNombresPremiers) {
            s += contenu + " ";
        }
        return s;
    }

    public void estDans(int nombre) {
        System.out.println(this.lesNombresPremiers.contains(nombre));
    }
}
