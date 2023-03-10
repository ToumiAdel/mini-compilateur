import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Interpreteur interpreteur = Interpreteur.getInstance();
        Scanner input = new Scanner(System.in);
        System.out.println("Utilisez les commandes : let / print / EXIT.");

        while(interpreteur.getContinuer()) {
            System.out.print("->");
            interpreteur.evaluer(input.nextLine());
        }
        System.out.println("fin du programme");
    }
}
