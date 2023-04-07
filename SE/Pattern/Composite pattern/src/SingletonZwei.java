import java.util.ArrayList;

public class SingletonZwei {
//Aufgabe 12 2.1
   private static SingletonZwei uniqueInstance;
    String name = "SingletonTest";

    static int count = 0;

    public String getName(){
        return name;
    }

    public int getCount(){
        return count;
    }

    public void setName(String name){
        this.name = name;
    }

    private SingletonZwei(){

    }

    public synchronized static SingletonZwei getUniqueInstance(){
        if(uniqueInstance == null){
            count++;
            uniqueInstance = new SingletonZwei();
        }

        return uniqueInstance;
    }


}

