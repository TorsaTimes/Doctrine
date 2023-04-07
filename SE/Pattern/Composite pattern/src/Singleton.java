import java.util.ArrayList;

public class Singleton {
//Aufgabe 12 2.2
    private static ArrayList<Singleton> uniqueInstance = new ArrayList<Singleton>();
    String name = "SingletonTest";
    static int max =5;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    private Singleton(){

    }

    public synchronized static ArrayList<Singleton> getUniqueInstance(){
        if(uniqueInstance.size() < max){
            uniqueInstance.add(new Singleton());
        }
        System.out.println("Max erreicht");
        return uniqueInstance;
    }


}
