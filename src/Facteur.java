import javax.lang.model.element.Element;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Facteur implements IAnalyse{
    private String entity;
    private Composite subent = new Composite();
    public Facteur(String entity){
        this.entity = entity ;
    }
    public boolean analyser(){
        if (this.entity.contains("^^")  || (this.entity.charAt(this.entity.length()-1) == '^') || (this.entity.charAt(0) == '^') ){
            System.out.println("Erreur dans le Facteur : "+this.entity);
            return false;
        }
        String[] nomElement = this.entity.split("\\^");

        for (String child : nomElement){
            Elementt el = new Elementt(child) {
            };
            this.subent.add(el);
        }

        return this.subent.analyser();
    }

    public float getVal(){
        List<IAnalyse> childs = new ArrayList<IAnalyse>();
        childs = this.subent.getChildren();
        int i = 0 ;
        float val = 1 ;
        for (IAnalyse child : childs){
            if (i == 0){
                val = child.getVal();
            } else {
                val = (float) Math.pow(val,child.getVal());
            }
            i++ ;
        }
        return val;
    }
}
