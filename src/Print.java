public class Print implements ICommande {
    public Print() {
    }

    public boolean evaluer(String commande) {
        Expression exp = new Expression(commande.trim());
        if (exp.analyser()){
            System.out.println(exp.getVal());
            System.out.println("OK.");
        }
        boolean bool = true;
        return bool;
    }
}
