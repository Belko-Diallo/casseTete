package nombrePremier;

public class Main {
    public static void main(String[] args) {
        NombrePremier liste = new NombrePremier(1000);
        System.out.println(liste.toString());
        liste.estDans(96);
    }
}
