package Calculatrice;

import javax.swing.*;

public class Bouton extends JButton {
    private String nom;

    public Bouton(String s) {
        super(s);
        this.nom = s;
    }
}
