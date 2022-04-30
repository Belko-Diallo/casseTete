package recherche;

import recherche.sort.ComparatorChefLieu;
import recherche.sort.ComparatorCodeRegion;
import recherche.sort.ComparatorNomDepart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        SortedSet<Departement> lesDepartements = new TreeSet<>();
        initialiserDepartement(lesDepartements);

        lesDepartements.stream().forEach(System.out::println);

        //rechercheDepartement(lesDepartements, "loiret");
        //rechercheCodeRegion(lesDepartements,"5");
        //rechercheChefLieu(lesDepartements,"29");
        //rechercheCodeDepartement(lesDepartements,"45");
    }

    public static void initialiserDepartement(SortedSet<Departement> lesDepartements) {
        Path fichier = Paths.get("src\\recherche\\departement2020.csv");
        List<String> lesLignes = null;
        try {
            lesLignes = Files.readAllLines(fichier);
        } catch (IOException e) {
            System.out.println("Impossible de lire le fichier.");
        }
        if (lesLignes.size() < 2) {
            System.out.println("Le fichier est vide.");
            System.exit(0);
        }
        for (int i = 1; i < lesLignes.size(); i++) {
            String[] tab = lesLignes.get(i).split(",");
            lesDepartements.add(new Departement(tab[0], tab[1], tab[2], tab[3], tab[6]));
        }
    }

    public static void rechercheDepartement(Set<Departement> lesDepartements, String recherche) {
        lesDepartements.stream().filter(e -> e.nomDepart.toUpperCase().contains(recherche.toUpperCase()))
                .sorted(new ComparatorNomDepart())
                .forEach(System.out::println);
    }

    public static void rechercheCodeRegion(Set<Departement> lesDepartements, String recherche) {
        lesDepartements.stream().filter(e -> e.codeRegion.contains(recherche))
                .sorted(new ComparatorCodeRegion())
                .forEach(System.out::println);
    }

    public static void rechercheChefLieu(Set<Departement> lesDepartements, String s) {
        lesDepartements.stream().filter(e -> e.chefLieu.toUpperCase().contains(s))
                .sorted(new ComparatorChefLieu())
                .forEach(System.out::println);
    }

    public static void rechercheCodeDepartement(Set<Departement> lesDepartement, String s) {
        lesDepartement.stream().filter(e -> e.codeDepart.contains(s))
                .forEach(System.out::println);
    }
}
