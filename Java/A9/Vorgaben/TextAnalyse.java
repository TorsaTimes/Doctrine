import java.io.*;

public class TextAnalyse {
    private static boolean isLetter(char c) {
       return ( (('a' <= c) && (c <= 'z')) ||
                (('A' <= c) && (c <= 'Z')) ||
                (c=='ß') ||
                (c=='ä') || (c=='ö') || (c=='ü') ||
                (c=='Ä') || (c=='Ö') || (c=='Ü')
              );
    }
	
    private static String readWord(BufferedReader f) throws IOException {
       String s= new String();
       char c;
       int ci;
       // wait for next letter
       do {ci=f.read();
           c=(char)ci;
          } while (!isLetter(c) && (ci!=-1));
       // wait for end of word
       while (isLetter(c)) {
    	  s += c;
    	  ci=f.read();
    	  c=(char)ci;
       }
       if (s.length()==0)
    	 return null;
       else
    	 return s;
    }
    
    public static void main(String[] args) {
      try {	
    	   BufferedReader f=new BufferedReader(new FileReader("Beispieltext.txt"));
    	   String s;

           while ((s=TextAnalyse.readWord(f))!=null) {
        	  System.out.println("Gelesenes Wort:" + s);
           }  
          } catch (IOException e) {
               System.out.println("Fehler beim Lesen der Datei:" +e.getMessage());	
            }
    }
}
