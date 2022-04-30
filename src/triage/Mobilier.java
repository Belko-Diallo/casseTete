package triage;

public class Mobilier implements Comparable<Mobilier> {
    public String nom;
    public String couleur;
    public String taille;
    public Double prix;
    public Integer quantite;
    public Boolean electronique;

    public Mobilier(String nom, String couleur, String taille, Double prix, Integer quantite, Boolean electronique) {
        this.nom = nom;
        this.couleur = couleur;
        this.taille = taille;
        this.prix = prix;
        this.quantite = quantite;
        this.electronique = electronique;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                nom +
                ", " + couleur +
                ", " + taille +
                ", " + prix +
                ", " + quantite +
                ", " + electronique +
                '}' + '\n';
    }

    @Override
    public int compareTo(Mobilier m) {
        return this.nom.compareTo(m.nom);
    }
}
