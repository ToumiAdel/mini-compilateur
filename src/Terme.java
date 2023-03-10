import java.util.ArrayList;
import java.util.List;

public class Terme implements IAnalyse{
    private String entity;
    private Composite subent = new Composite() ;

    private List<Character> op = new ArrayList<Character>();
    public Terme(String entity){
        this.entity = entity ;
    }
    public boolean analyser(){
        if (this.entity.contains("//") || this.entity.contains("**") || this.entity.contains("/*") || this.entity.contains("*/") || (this.entity.charAt(this.entity.length()-1) == '*') || (this.entity.charAt(this.entity.length()-1) == '/') || (this.entity.charAt(0) == '/') || (this.entity.charAt(0) == '*')){
            return false;
        }

        String[] nomFacteur = this.entity.split("(?<!\\(\\w)[/*](?!\\w\\))");
        for(Character c : this.entity.toCharArray()) {
            if (c == '/' || c == '*') {
                this.op.add(c);
            }
        }
        for (String child : nomFacteur){
            Facteur facteur = new Facteur(child);
            this.subent.add(facteur);
        }

        return this.subent.analyser();
    }

    public float getVal(){
        List<IAnalyse> childs = new ArrayList<IAnalyse>();
        childs = this.subent.getChildren();
        int i = 0 ;
        float val = 1 ;

        for (IAnalyse child : childs){
            if (this.op.isEmpty() || i == 0){
                val = child.getVal();
            } else {
                if (this.op.get(i-1) == '*'){
                    val *= child.getVal();
                }
                else {
                    val /= child.getVal();
                }
            }
            i++ ;
        }
        return val;
    }
}
