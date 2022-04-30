package formatage;

import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        int num1 = 8, num2 = 5;

        System.out.printf("%d,%d\n", num1, num2);
        String s = String.format("[%d,%d]", num1, num2);
        System.out.println(s);

        System.out.println();

        System.out.printf(">%5d<\n", num1);
        System.out.printf(">%05d<\n", num1);
        System.out.printf(">%, d<\n", 1_000_000);

        System.out.println();
        System.out.println("Base");
        System.out.println("%d:décimale ; %o:octale ; %x:hexadécimale");

        System.out.printf("%d %o %x\n", 25, 25, 25);
        System.out.printf("<%05x>\n", 25, 25, 25);

        System.out.println();
        System.out.println("Flottant(e:exponentiel)");

        System.out.printf("%f\n", Math.PI);
        System.out.printf("%5.2f\n", Math.PI);
        System.out.printf("%05.2f\n", Math.PI);
        System.out.printf("%5.4f\n", Math.PI);
        System.out.printf("%e\n", Math.PI);

        System.out.println();
        System.out.println("Caractère & chaîne");

        System.out.printf("%c - %s\n", 'z', "zorro");
        System.out.printf(">%10s<\n", "toto");
        System.out.printf(">%-10s<\n", "toto");
        System.out.printf(">%-10s< %% \n", "toto");

        System.out.println();
        System.out.println("Autres Types");

        System.out.printf("%b \n", true);
        System.out.printf("%h \n", new Date());//sout(Integer.toHexString(arg.hashCode());
        System.out.printf("%tF %tT\n", new Date(), new Date());

        System.out.println("+-----------+---------------------+----------------------+");
        System.out.println("|Taille(ko) +   Date       Time   +      Nom Fichier     |");
        System.out.println("+-----------+---------------------+----------------------+");
        File[] files = new File(".").listFiles();
        for (File file : files) {
            long sizeKo = files.length;
            Date lastModified = new Date(file.lastModified());
            String name = file.getName();
            System.out.printf("|%,10d | %tF %tT | %-20s |\n", sizeKo, lastModified, lastModified, name);
        }
        System.out.println("+-----------+---------------------+----------------------+");
    }
}
