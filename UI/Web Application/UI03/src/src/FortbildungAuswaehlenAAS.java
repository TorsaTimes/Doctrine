package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class FortbildungAuswaehlenAAS {


//    public static String fortbildung;
    public static HashSet<String> fortbildungCollectionString = new HashSet<>();
    public static String fortbildung = "-------";

    static{
        for(Fortbildung f: Fortbildung.fortbildungHashSet){
            fortbildungCollectionString.add(f.getFortbildungTitle());
        }
    }

    public HashSet<String> getFortbildungCollectionString(){
        return fortbildungCollectionString;
    }

    public String getFortbildung() {
        return this.fortbildung;
    }


    public void setFortbildung(String fortbildung) {
        this.fortbildung = fortbildung;
    }


    public void oeffnen()throws IOException {


    }


}

