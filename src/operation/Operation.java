package operation;

import java.util.*;

public class Operation {
    String op;
    Double somme = 0.;
    String[] lesOperandes;
    String[] lesOperateurs;

    public Operation(String chaine, int zero) {
        op = chaine.replace(" ", "");
    }

    public Operation(String chaine) {
        if (chaine.equals("Bien joué !")) {
            println(chaine);
            System.exit(0);
        }
        op = chaine.replace(" ", "");
        op = chaine.replace(".", ",");
        String original = this.op;
        this.verificationExpression();
        if (this.op.contains("(")) {
            this.calculerParenthese();
        } else {
            this.initialisationOperateur();
            this.initialisationOperande();
        }
        String resultat = String.valueOf(this.somme).replace(".", ",");
        println(original + " = " + resultat);
    }

    public void ajouter(String s) {
        this.op = s;
    }

    public Double operation() {
        this.verificationExpression();
        this.initialisationOperateur();
        this.initialisationOperande();
        return this.somme;
    }

    /*
        Cette version n'admet aucun double signe par soucis d'implémentation
            ex: 4 * -5
            l'utilisateur pourra tout de même remplacer/simplfier les signes :
                '-' prend le dessus sur '+'
                la division par un nombre négatif pourra se faire avec un numérateur négatif
                    dans le cas de numérateur et dénominateur négatif => -/- = +
                la multiplication par un second opérande négatif pourra se faire avec son premier opérande négatif
                    dans le cas de deux nombres négatif => -*- = +
     */
    public void verificationExpression() {
        if (this.op.contains("(") || this.op.contains(")")) {
            this.memeNbParenthese();
            if (this.op.matches(".*[+*/-]\\).*")) throw new IllegalArgumentException("Mauvais parenthésage.");
            if (this.op.matches(".*\\([*/-].*")) throw new IllegalArgumentException("Mauvais parenthésage.");
            if (this.op.matches(".*\\(\\).*")) throw new IllegalArgumentException("Mauvais parenthésage.");
        } else {
            this.op = this.op.replace("%", "/100");
            if (this.op.matches("(\\+\\+)|(\\+-)|(\\+\\*)|(\\+/)" + // Opérateur après un '+'
                    "|(//)|(/\\*)|(/\\+)|(/-)" + // Opérateur après un '/'
                    "|(\\*/)|(\\*\\*)|(\\*\\+)|(\\*-)" + // Opérateur après un '*'
                    "|(-/)|(-\\*)|(-\\+)|(--)")) { // Opérateur après un '-'
                throw new IllegalArgumentException("L'opération n'est pas valide (motif suite d'opérateur incohérent)");
            } else if (this.op.contains(",")) {
                if (!this.op.matches("^[+-]?([0-9]+(,[0-9]+)?[+/*-])*([0-9]+(,[0-9])?)$")) {
                    throw new IllegalArgumentException("L'opération n'est pas valide (motif virgule invalide)");
                }
            } else {
                if (!this.op.matches("^[+-]?[0-9]+[0-9+/*-]*[0-9]$")) {
                    throw new IllegalArgumentException("L'opération n'est pas valide (cas général)");
                }
            }
        }
    }

    public void initialisationOperateur() {

        this.lesOperateurs = op.replaceAll("[0-9],?", "").split("");
    }

    public void initialisationOperande() {
        this.op = this.op.replace(",", ".");
        if (this.lesOperateurs.length > 1 && this.op.matches(".+[*/].+") && !this.aParenthese()) {
            this.calculAvecPriorite();
        } else {
            if (this.op.startsWith("+") || this.op.startsWith("-")) {
                this.lesOperandes = op.substring(1).split("[+/*-]");
                this.calculSansPrioriteAvecSigne();
            } else {
                this.lesOperandes = op.split("[+/*-]");
                this.calculSansPriorite();
            }
            this.op = this.op.replace(".", ",");
            this.op = this.op.replace("/100", "%");
        }
    }

    public void calculSansPrioriteAvecSigne() {
        int operation = 1;
        if (this.lesOperateurs[0].equals("+")) {
            this.somme = Double.valueOf(this.lesOperandes[0]);
        } else {
            this.somme = -Double.parseDouble(this.lesOperandes[0]);
        }
        if (this.lesOperateurs.length > 1) {
            do {
                switch (this.lesOperateurs[operation]) {
                    case "+":
                        this.somme += Double.parseDouble(lesOperandes[operation]);
                        break;
                    case "-":
                        this.somme -= Double.parseDouble(lesOperandes[operation]);
                        break;
                    case "*":
                        this.somme *= Double.parseDouble(lesOperandes[operation]);
                        break;
                    case "/":
                        this.somme /= Double.parseDouble(lesOperandes[operation]);
                        break;
                }
                operation++;
            } while (operation < this.lesOperateurs.length);
        }
    }

    public void calculSansPriorite() {
        if (this.lesOperateurs.length != 1) {
            int operation = 1;
            String firstOperande = this.lesOperateurs[0];
            if (firstOperande.equals("+")) {
                this.somme = Double.parseDouble(lesOperandes[0]) + Double.parseDouble(lesOperandes[1]);
            } else if (firstOperande.equals("-")) {
                this.somme = Double.parseDouble(lesOperandes[0]) - Double.parseDouble(lesOperandes[1]);
            } else if (firstOperande.equals("*")) {
                this.somme = Double.parseDouble(lesOperandes[0]) * Double.parseDouble(lesOperandes[1]);
            } else {
                this.somme = Double.parseDouble(lesOperandes[0]) / Double.parseDouble(lesOperandes[1]);
            }
            if (this.lesOperateurs.length > 1) {
                do {
                    switch (this.lesOperateurs[operation]) {
                        case "+":
                            this.somme += Double.parseDouble(lesOperandes[operation + 1]);
                            break;
                        case "-":
                            this.somme -= Double.parseDouble(lesOperandes[operation + 1]);
                            break;
                        case "*":
                            this.somme *= Double.parseDouble(lesOperandes[operation + 1]);
                            break;
                        case "/":
                            this.somme /= Double.parseDouble(lesOperandes[operation + 1]);
                            break;
                    }
                    operation++;
                } while (operation < this.lesOperateurs.length);
            }
        } else {
            if (this.lesOperandes.length == 1) this.somme = Double.parseDouble(this.lesOperandes[0]);
            else if (this.lesOperateurs[0].equals("+")) {
                this.somme = Double.parseDouble(this.lesOperandes[0]) + Double.parseDouble(this.lesOperandes[1]);
            } else if (this.lesOperateurs[0].equals("-")) {
                this.somme = Double.parseDouble(this.lesOperandes[0]) - Double.parseDouble(this.lesOperandes[1]);
            } else if (this.lesOperateurs[0].equals("*")) {
                this.somme = Double.parseDouble(this.lesOperandes[0]) * Double.parseDouble(this.lesOperandes[1]);
            } else if (this.lesOperateurs[0].equals("/")) {
                this.somme = Double.parseDouble(this.lesOperandes[0]) / Double.parseDouble(this.lesOperandes[1]);
            }
        }
    }

    public void println(Object s) {
        System.out.println(s);
    }

    public boolean aParenthese() {
        return (op.contains("(") || op.contains(")"));

//        StringTokenizer decouper = new StringTokenizer(this.op,"(");
//        while(decouper.hasMoreTokens()){
//            println(decouper.nextToken());
//        }
    }

    public void memeNbParenthese() {
        int parenthese = 0;
        ;
        for (int i = 0; i < this.op.length(); i++) {
            if (this.op.charAt(i) == '(') {
                parenthese++;
            }
            if (this.op.charAt(i) == ')') {
                parenthese--;
            }
        }
        if (parenthese != 0) throw new IllegalArgumentException("Mauvais parenthésage !");
    }

    public int nbParenthese() {
        int cpt = 0;
        for (int i = 0; i < this.op.length(); i++) {
            if (this.op.charAt(i) == '(') {
                cpt++;
            }
        }
        return cpt;
    }

    public String splitNiveau2() {
        this.memeNbParenthese();
        Set<Integer> traiter = new HashSet<>();
        List<String> parenthese = new ArrayList<>();
        for (int i = 0; i < this.op.length(); i++) {
            if (this.op.charAt(i) == ')' && !traiter.contains(i)) {
                traiter.add(i);
                for (int y = i; y >= 0; y--) {
                    if (this.op.charAt(y) == '(' && !traiter.contains(y)) {
                        traiter.add(y);
                        parenthese.add(this.op.substring(y, i + 1));
                    }
                }
            }
        }
        return parenthese.get(0);
    }

    public void calculerParenthese() {
        int taille = this.nbParenthese();
        int n = 0;
        Operation secondaire = new Operation("", 0);
        while (n < taille) {
            String operation = splitNiveau2();
            if (operation.isEmpty()) throw new EmptyStackException();
            String ancien = operation;
            operation = operation.replace("(", "");
            operation = operation.replace(")", "");
            secondaire.ajouter(operation);
            Double temp = secondaire.operation();
            String temp2 = String.valueOf(temp).replace(".", ".");
            this.remplacement(ancien, temp2);
            n++;
        }
        this.somme += this.operation();
    }

    public void remplacement(String chaine, String temp) {
        this.op = this.op.replace(".", ",");
        chaine = chaine.replace(".", ",");
        if (!this.op.contains(chaine)) throw new IllegalArgumentException("Aucune correspondance !");
        this.op = this.op.replace(chaine, temp);
    }

    public void calculAvecPriorite() {
        int index = -1;
        Operation tempo = new Operation("", 0);
        while (op.matches(".+[*/].+")) {
            for (int i = 0; i < op.length(); i++) {
                if (op.charAt(i) == '*' || op.charAt(i) == '/') {
                    index = i;
                    break;
                }
            }
            String s = recupererDoubleAvant(index) + op.charAt(index) + recupererDoubleApres(index);
            s = s.replace(".", ",");
            tempo.ajouter(s);
            this.remplacement(s, String.valueOf(tempo.operation()));
        }
        this.inversionPonctuation();
        this.operation();
    }

    public String recupererDoubleAvant(int index) {
        int debut = index;
        for (; debut > -1; debut--) {
            if (this.op.charAt(debut) == '+' || this.op.charAt(debut) == '-' || debut == 0) {
                break;
            }
        }
        if (debut == 0) return op.substring(debut, index);
        return op.substring(++debut, index);
    }

    public String recupererDoubleApres(int index) {
        int fin = ++index, taille = op.length();
        for (; fin < taille; fin++) {
            if (this.op.charAt(fin) == '+' || this.op.charAt(fin) == '-'
                    || this.op.charAt(fin) == '*' || this.op.charAt(fin) == '/'
                    || fin == taille - 1) {
                break;
            }
        }
        if (fin == index) return op.substring(index);
        if (fin == taille - 1) return op.substring(index, ++fin);
        return op.substring(index, fin);
    }

    public void inversionPonctuation() {
        if (this.op.contains(".")) {
            this.op = this.op.replace(".", ",");
        } else {
            this.op = this.op.replace(",", ".");
        }
    }

    @Override
    public String toString() {
        return "Operation{" +
                "op='" + op + '\'' +
                ", somme=" + somme +
                ", lesOperandes=" + Arrays.toString(lesOperandes) +
                ", lesOperateurs=" + Arrays.toString(lesOperateurs) +
                "}\n";
    }
}
