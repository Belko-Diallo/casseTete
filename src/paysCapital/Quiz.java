package paysCapital;

import java.util.*;

public class Quiz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListePays lesPays = new ListePays(Initialisation.main());
        //lesPays.listePays.stream().map(Pays::toString).forEach(System.out::print);

        while (true) {
            List<Pays> aJouer = new ArrayList<>(lesPays.listePays);
            if (aJouer.isEmpty()) {
                break;
            }
            Collections.shuffle(aJouer);
            Pays paysEnJeu = aJouer.get(0);
            lesPays.listePays.remove(paysEnJeu);
            Pays capitalFactice2 = lesPays.listePays.get((int) (Math.random() * lesPays.listePays.size()) + 1);
            Pays capitalFactice1 = lesPays.listePays.get((int) (Math.random() * lesPays.listePays.size()) + 1);
            int position = (int) (Math.random() * 3) + 1;
            String jeu;
            if (position == 1) {
                jeu = String.format("1- %s  2-  %s  3- %s", paysEnJeu.capital, capitalFactice1.capital, capitalFactice2.capital);
            } else if (position == 2) {
                jeu = String.format("1- %s  2-  %s  3- %s", capitalFactice1.capital, paysEnJeu.capital, capitalFactice2.capital);
            } else {
                jeu = String.format("1- %s  2-  %s  3- %s", capitalFactice1.capital, capitalFactice2.capital, paysEnJeu.capital);
            }
            System.out.println(paysEnJeu.nom + " : ");
            System.out.println(jeu);

            if (in.nextInt() == position) {
                System.out.println("Vrai");
            } else {
                System.out.println(paysEnJeu.capital);
            }
        }
    }
}
