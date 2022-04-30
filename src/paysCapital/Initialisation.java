package paysCapital;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Initialisation {
    public static List<Pays> main() {
        List<Pays> lesPays = new ArrayList<>();
        Path fichier = Paths.get("src\\paysCapital\\liste197etats2020.csv");
        List<String> lesLignes = null;
        try {
            lesLignes = Files.readAllLines(fichier);
        } catch (IOException e) {
            System.out.print("Le fichier n'existe pas.");
            System.exit(0);
        }
        if (lesLignes.size() < 2) {
            System.out.println("Le fichier est vide.");
            System.exit(0);
        }
        for (int i = 1; i < lesLignes.size(); i++) {
            String[] tab = lesLignes.get(i).split(";");
            lesPays.add(new Pays(tab[0], tab[5]));
        }
        return lesPays;
    }
}
