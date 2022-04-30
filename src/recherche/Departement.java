package recherche;

public class Departement implements Comparable<Departement> {
    public String codeDepart;
    public String codeRegion;
    public String chefLieu;
    String typeNom;
    public String nomDepart;

    public Departement(String codeDepart, String codeRegion, String chefLieu, String typeNom, String nomDepart) {
        this.codeDepart = codeDepart;
        this.codeRegion = codeRegion;
        this.chefLieu = chefLieu;
        this.typeNom = typeNom;
        this.nomDepart = nomDepart;
    }

    @Override
    public String toString() {
        return "Code Département : " + codeDepart +
                ", Code Région : " + codeRegion +
                ", Chef Lieu : " + chefLieu +
                ", Nom Département : " + this.normalisation() + nomDepart;
    }

    @Override
    public int compareTo(Departement o) {
        return this.codeDepart.compareTo(o.codeDepart);
    }

    private String normalisation() {
        String[] article = {"", "", "Le", "La", "Les", "L'", "Aux"};
        int index = Integer.parseInt(this.typeNom);
        if (index < 2 || index == 5) return article[index];
        return article[index] + " ";
    }
}
