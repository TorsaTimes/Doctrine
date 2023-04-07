
public class Textanalyse {
		

		    public static char gross(char c){//Erkennt grossbuchstaben
		        int zahl = (int)c-32;
		        return (char)zahl;
		    }

			public static void main(String[] args) {
				
				int count = 0;//zeahlervariable der einzelnen Buchstaben
				int[] buchstaben = new int[26];//Array mit denn jeweiligen Buchstaben
				
				for (int i = 0; i < args.length; i++) {
					if (args[i] != null) {
						count++;//zählt die anzahl der wörter  
					}
		            for(int z = 0; z < args[i].length(); z++){
		                char u = args[i].charAt(z);
		                int ascii = (int)u;
		                    if(ascii >= 97){
		                        u = gross(u);
		                        ascii = (int)u;
		                    }
		                    buchstaben[u-65]++;
		            
		        }
		                System.out.println(i+1 + ". Wort hat " + args[i].length() + " Buchstaben ");

		        }
		                System.out.println("Deine Eingabe hat " + count + " Wörter ");

		        for(int i = 0; i < buchstaben.length; i++){
		            if(buchstaben[i] > 0){
		                int konv = i + 65; 
		                char letter = (char)konv;
		                System.out.println(letter + ": " + buchstaben[i] + "  ");
		        }
		        }


	}
}
