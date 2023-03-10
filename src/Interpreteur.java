import java.util.HashMap;
import java.util.Scanner;

public class Interpreteur {
    public HashMap<String, Isymbole> tableSymboles = new HashMap<String,Isymbole>();
    private static Interpreteur instance;
    private ICommande commande;
    private boolean continuer = true;

    private Interpreteur() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public boolean getContinuer() {
        return this.continuer;
    }

    public static Interpreteur getInstance() {
        if (instance == null) {
            instance = new Interpreteur();
        }

        return instance;
    }

    public void addSymbole(String nom, Isymbole symbole) {
        this.tableSymboles.put(nom, symbole);
    }

    public float getSymbole(String nom) {
        return this.tableSymboles.get(nom).valeur();
    }

    public boolean verifierSymbole(String nom){
        if(this.tableSymboles.containsKey(nom)){
            return true;
        }
        else {
            return false;
        }
    }

    private void setCommande(ICommande commande) {
        this.commande = commande;
    }

    public boolean evaluer(String commande) {
        Scanner sc = new Scanner(commande);
        String intruction = sc.next();
        if (intruction.equals("EXIT")) {
            this.setCommande(new Exit());
            this.continuer = false;
            return true;
        } else if (intruction.equals("let")) {
            this.setCommande(new Let());
            this.commande.evaluer(sc.nextLine());
            this.continuer = true;
            return true;
        } else if (intruction.equals("print")) {
            this.setCommande(new Print());
            this.commande.evaluer(sc.nextLine());
            this.continuer = true;
            return true;
        } else {
            return false;
        }
    }

    public void executer(String commande) {
    }
}
