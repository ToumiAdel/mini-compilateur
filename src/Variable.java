import java.util.HashMap;

public class Variable implements IAnalyse,Isymbole{
    private String entity;
    private float value ;

    public Variable(String entity){
        this.entity = entity ;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean verifierTable(){
        Interpreteur interpreteur = Interpreteur.getInstance();
        if (this.analyser()){
            return  interpreteur.verifierSymbole(this.entity) ;
        }
        else{
            return false;
        }

    }

    public boolean analyser(){
        if( Character.isDigit(this.entity.charAt(0))){
            System.out.println("Nom de variable incorrect");
            return false ;
        }
        else {
            return true;
        }

    }

    public float getVal() {
        return this.value;
    }

    @Override
    public void stocker(HashMap<String, Isymbole> tableSymboles ){
        tableSymboles.put(this.entity,this);
    }

    public float valeur(){
        return this.value;
    }
}
