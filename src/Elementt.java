public class Elementt implements IAnalyse{
    private String entity;
    private IAnalyse value ;

    private int type;

    public Elementt(String entity){
        this.entity = entity;
    }
    public boolean analyser(){
        if ((this.entity.charAt(this.entity.length()-1) == ')') &&  (this.entity.charAt(0) == '(')){
            Expression exp = new Expression(this.entity.substring(1,this.entity.length()-1));

            if (exp.analyser()){
                this.value = exp;
                this.type = 1;
                return true ;
            }
        }

        try {
            Float.parseFloat(entity);
            this.type = 0;
            return true;
        } catch (Exception e) {
            
            Variable var = new Variable(this.entity);

            if (var.verifierTable()){
                this.value = var ;

                this.type = 1;
                return true;
            }
            else {
                System.out.println("Erreur, variable innexistante");
                return false;
            }


        }

    }

    public float getVal(){
        if (type == 1 ){
            Interpreteur interpreteur = Interpreteur.getInstance();
            return interpreteur.getSymbole(this.entity);
        }

        else {
           return Float.parseFloat(entity);
        }

    }
}
