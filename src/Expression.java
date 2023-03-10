import java.util.ArrayList;
import java.util.List;

public class Expression implements IAnalyse{

    private String entity;
    private Composite subent = new Composite();

    private List<Character> op = new ArrayList<Character>();
    public Expression(String entity){
        this.entity = entity;
    }

    public boolean verifyPar(){
        int i = 0;
        for (Character c : this.entity.toCharArray()){
            if(c == '('){
                i++ ;
            }
            if (c == ')'){
                i-- ;
                if ( i < 0){
                    System.out.println("erreur de paranthèses");
                    return false;}
            }
        }
        return i == 0;
    }
    public boolean analyser(){
        if (!this.verifyPar()){
            return false;
        }
        if (this.entity.contains("+-") || this.entity.contains("-+") || this.entity.contains("--") || this.entity.contains("++") || (this.entity.charAt(this.entity.length()-1) == '+') || (this.entity.charAt(this.entity.length()-1) == '-')){
            return false;
        }
        String[] nomTerme = this.entity.split("(?<!\\(\\w)[+-](?!\\w\\))");
        for(Character c : this.entity.toCharArray()){

            if (c == '+' || c == '-'){

                this.op.add(c);
            }
        }
        Terme terme;
        for (String child : nomTerme){
            terme = new Terme(child);
            this.subent.add(terme);
        }
        return this.subent.analyser();
    }


    public float getVal(){
        List<IAnalyse> childs = new ArrayList<IAnalyse>();
        childs = this.subent.getChildren();
        int i = 0 ;
        float val = 0 ;
        for (IAnalyse child : childs) {
            if (this.op.isEmpty() || i == 0) {
                val = child.getVal();
            } else {
                if (this.op.get(i - 1) == '+') {
                    val += child.getVal();
                } else {
                    val -= child.getVal();
                }
            }
            i++;
        }
    return val;
    }
}
