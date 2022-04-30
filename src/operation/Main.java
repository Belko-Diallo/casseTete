package operation;

import com.sun.deploy.uitoolkit.ui.ConsoleController;

import java.io.Console;
// problème virgule point lors de enième opération
public class Main {
    public static void main(String[] args) {
        new Operation("2*(7/8)");
    }

    public static double calculer(String args) {
        Operation operation = new Operation(args);
        return operation.somme;
    }
}
