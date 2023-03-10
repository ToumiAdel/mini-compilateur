import java.util.*;

public class Composite implements IAnalyse{
    private List<IAnalyse> entity = new ArrayList<IAnalyse>() ;

    public void add(IAnalyse entity){
    this.entity.add(entity);
    }


    public void remove(IAnalyse entity){
    this.entity.remove(entity);
    }

    @Override
    public boolean analyser() {
        int i = 0 ;
        for (IAnalyse child : this.entity){
            if (!child.analyser()){
                return false;
            }
            i++;
        }
        return true;
    }

    public List<IAnalyse> getChildren(){
    return this.entity;
    }

    public float getVal(){
        return 0;
    }


}
