import java.util.HashMap;
import java.math.*;
import java.util.Scanner;

public class Fonction implements Isymbole{
    private String entity;
    private String name ;

    public Fonction(String entity){
        this.entity = entity ;
    }
    public boolean analyser(){

        String nomfonction = this.entity.split("[(]")[0];
        try{
            System.out.println( FonctionsStandards.valueOf(nomfonction));
            this.name = nomfonction;
            this.entity.replace(nomfonction,"");
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public float getVal(){
        Expression expression = new Expression(this.entity);
        if(FonctionsStandards.valueOf(name).toString().equals("cos")){
            return (float) Math.cos(expression.getVal());
        }
        if(FonctionsStandards.valueOf(name).toString().equals("sin")){
            return (float) Math.sin(expression.getVal());
        }
        if(FonctionsStandards.valueOf(name).toString().equals("tan")){
            return (float) Math.tan(expression.getVal());
        }
        if(FonctionsStandards.valueOf(name).toString().equals("abs")){
            return  Math.abs(expression.getVal());
        }
        return -1 ;
    }

    @Override
    public void stocker(HashMap<String, Isymbole> tableSymboles ){
        tableSymboles.put(this.entity,this);
    }

    public float valeur(){
        return -1;
    }
}
