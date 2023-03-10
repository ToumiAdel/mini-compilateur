//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Let implements ICommande {
    public boolean evaluer(String commande) {
        boolean bool = true;
        Interpreteur interpreteur = Interpreteur.getInstance();
        String[] tokens=commande.split("=");
        if (tokens.length != 2){
            System.out.println("erreur de syntaxe dans LET");
            return false;
        }
        Variable var = new Variable(tokens[0].trim()) ;
        Expression exp = new Expression(tokens[1].trim());
        if (var.analyser() && exp.analyser()){
            var.setValue(exp.getVal());
            var.stocker(interpreteur.tableSymboles);
            System.out.println("OK.");
        }


        return bool;
    }
}
