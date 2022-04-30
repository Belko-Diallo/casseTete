package triage;
//Lambda expression & Référence & Prédicat(filtre/stream)
//Test Horaire

import triage.ComparatorAsc.ComparatorAscPrix;
import triage.ComparatorDesc.*;

import java.time.LocalTime;
import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Set<Mobilier> leMobilier = new HashSet<>();

        leMobilier.add(new Mobilier("Lit", "Beige", "Grand", 400., 1, false));
        leMobilier.add(new Mobilier("Chaise de bureau", "Noir", "Normal", 50., 1, false));
        leMobilier.add(new Mobilier("Télévision", "Noir", "Petit", 100., 1, true));
        leMobilier.add(new Mobilier("Réfrigirateur", "Gris", "Grand", 550., 1, true));
        leMobilier.add(new Mobilier("Table à manger", "Beige", "Normal", 250., 1, false));
        leMobilier.add(new Mobilier("Bureau", "Violet", "Normal", 150., 1, false));
        leMobilier.add(new Mobilier("Cuisine", "Marron", "Petit", 850., 1, false));
        leMobilier.add(new Mobilier("Micro-onde", "Blanc", "Normal", 80., 1, true));
        leMobilier.add(new Mobilier("Chaise", "Beige", "Normal", 50., 4, false));
        leMobilier.add(new Mobilier("Console de jeux", "Noir", "Normal", 500., 1, true));
        leMobilier.add(new Mobilier("Couvert de table", "Gris", "Normal", 20., 6, false));
        leMobilier.add(new Mobilier("Assiette", "Violet/Blanc", "Normal", 5., 3, false));
        leMobilier.add(new Mobilier("Assiette", "Blanc", "Normal", 5., 3, false));
        leMobilier.add(new Mobilier("Armoire", "Blanc", "Normal", 150., 1, false));
        leMobilier.add(new Mobilier("Lampe", "Rouge", "Normal", 15., 1, true));
        leMobilier.add(new Mobilier("Lumiere LED", "Gris", "Normal", 30., 2, true));

        //System.out.println(leMobilier.toString());
        List<Mobilier> list = new ArrayList<>(leMobilier);
        //list.stream().filter(e -> e.nom.contains("s")).forEach(System.out::print);
        //list.stream().filter(e -> e.taille.equalsIgnoreCase("grand")).forEach(System.out::print);
        //list.stream().filter(e -> e.prix > 500).filter(e -> e.electronique).forEach(System.out::print);
        System.out.println(list.stream().min(new ComparatorDescPrix()).toString());
        //System.out.println(list.toString());
        list.sort(new ComparatorDescTaille());
        list.sort((m1, m2) -> m1.nom.compareToIgnoreCase(m2.nom));
        /*
            Predicate<Mobilier> pred = (m) -> s.nom.length > 5;
         */
        /*
        list.sort(Comparator.comparing(o -> o.quantite));
        list.sort((o1, o2) -> {
            return o1.prix.compareTo(o2.prix);
        });*/

        /* Référence
        les méthodes doivent avoir le meme type de parametre
        utile pour la gestion d'évenement  dans le cas d'interface graphique
        objet.methode(this::autreMehode)
         */

        /*
        for(Mobilier m: list){
            System.out.println(m.prix);
        }
        list.forEach(System.out::println);
        */
    }
    /*
    LocalTime now;
    Long debut=System.currentTimeMillis(),fin;
    Long temps;
        while (true) {
        fin = System.currentTimeMillis();
        temps = fin - debut;
        if(temps % 1000 > 0) {
            debut+=1000;
            now = LocalTime.now();
            System.out.print(now + "\r");
        }
    }*/
}
