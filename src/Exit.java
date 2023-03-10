//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Exit implements ICommande {
    public Exit() {
    }

    public boolean evaluer(String commande) {
        return commande.equals("Exit");
    }
}
