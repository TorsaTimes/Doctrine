
import java.util.ArrayList;

public class Bauteil implements Component {

    ArrayList<Component> liste = new ArrayList<Component>();
    String name = "";
    public Bauteil(String name){
        this.name = name;
    }
//    @Override
//    public void print(String tab) {
//        System.out.println(tab + "-->" + name);
//        for (Component c : liste){
//            c.print(tab+"  ");
//        }
//
//    }

    public void add(Component c){
        liste.add(c);
    }
    
    @Override
   	public Object visit(GeraeteManagerVisitor g) {
   		return g.visit(this);
   	}
    
    public String getName() {
    	return this.name;
    }
    
    public ArrayList<Component> getArrayList(){
    	return liste;
    }
    
}
