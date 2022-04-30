package PreshTalWalker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] tab;
        System.out.println("Soyez prêt à résoudre l'énigme");
        for(int i=0;i<3;i++) {
            tab = alea();
            System.out.println(tab[0] + " + " + tab[1] + " = " + calcul(tab[0], tab[1]));
        }
        tab = alea();
        int resultat = calcul(tab[0], tab[1]);
        int choix;
        System.out.print(tab[0] + " + " + tab[1] + " = ");
        choix = in.nextInt();
        if(choix != resultat){
            System.out.println("La réponse est : "+resultat);
        }else{
            System.out.println("Bonne réponse !");
        }




    }

    public static int calcul(int a,int b){
        int fin = a + b;
        int debut = a - b;
        int decalage = String.valueOf(fin).length();
        return debut * (int)Math.pow(10,decalage) + fin;
    }

    public static int[] alea(){
        int[] tab = {(int) (Math.random() * 20), (int) (Math.random() * 20)};
        if(tab[0]<tab[1]){
            int tmp = tab[0];
            tab[0] = tab[1];
            tab[1] = tmp;
            return tab;
        }
        return tab;
    }
}
