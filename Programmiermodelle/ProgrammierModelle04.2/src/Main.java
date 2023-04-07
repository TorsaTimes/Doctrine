
public class Main {

	static String reverseRecursiv_help(String text, String accu) {

		if (text.length() == 0) {
			return accu;
		} else {
			int length = text.length();
			String text2 = text.substring(1, length);
			return reverseRecursiv_help(text2, text.charAt(0) + accu);
		}

	}
	static String reverseRecursiv(String text) {

		return reverseRecursiv_help(text, "");

	}

//	static String reverseRecursiv(String text) {
//
//		if (text.length() == 1) {
//			return text;
//		}
//		int length = text.length();
//		String text2 = text.substring(1, length);
//		String result = reverseRecursiv(text2) + text.charAt(0);
//		return result;
//	}

	public static void main(String[] args) {
		
		
		String s = "\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Wissenschaftliches Arbeiten und Recherchieren\r\n" + 
				"in\r\n" + 
				"Allgemeine Informatik (AIN 2)\r\n" + 
				"\r\n" + 
				"Wie wirkt sich Manipulation im Internet auf die   Gesellschaft aus?\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"		\r\n" + 
				"\r\n" + 
				"Referent:	Christina Metzger\r\n" + 
				"Vorgelegt am:	26.06.2019\r\n" + 
				"Vorgelegt von:	Samuele Tortomasi\r\n" + 
				"Matrikel-Nr. 260872\r\n" + 
				"Marktplatz 3.\r\n" + 
				"78120 Furtwangen im Schwarzwald\r\n" + 
				"Samuele.Tortomasi@hs-furtwangen.de\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"I. Abstract\r\n" + 
				"Die vorliegende Arbeit beschäftigt sich mit der Manipulation im Internet und der damit einhergehenden Auswirkung auf die Gesellschaft. Im ersten Kapi-tel wird die Definition von Manipulation für die folgende Arbeit ersichtlich erläutert. Im Fokus des zweiten Kapitels stehen die Instrumente, die für die Nutzung von Internet Manipulation verwendet werden. Dabei wird auf die Verwendung von Sozial-Bots, Filterblasen, Echokammern, Fake News, Trol-ling und Microtargeting eingegangen. Darauf aufbauend wird im dritten Ab-schnitt die Auswirkungen der Manipulationsinstrumente auf die Bereichen Sozial, Politik und Wissenschaft erläutert. Anschließend werden die Maß-nahmen und Präventionen gegen Internet Manipulation veranschaulicht erörtert. Ein Fazit und ein kurzer Ausblick auf die behandelten Themen be-schließen die Arbeit. Warum habe ich das Thema gewählt? Weil die Thema-tik in der heutigen Zeit aktuellen Stellenwert besitzt. Dem Stand der For-schung und statistischer Erkenntnissen nach ist Internet Manipulation in der gegenwärtigen Zeit ein gängiges Instrument in den Bereichen Politik, Gesellschaft und Wissenschaft.  \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Inhaltsverzeichnis\r\n" + 
				"\r\n" + 
				"Abstract………………………………………………………………………………I\r\n" + 
				"Inhaltsverzeichnis…………………………………………………………………II\r\n" + 
				"1. Einleitung	4\r\n" + 
				"2. Begriffserklärung	5\r\n" + 
				"3. Instrumente für Internet Manipulation	6\r\n" + 
				"3.1 Social-Bots	6\r\n" + 
				"3.2 Echokammern und Filterblasen	7\r\n" + 
				"3.3 Microtargeting………………………………………………………………..8\r\n" + 
				"4. Auswirkung der Internet Manipulation	9\r\n" + 
				"4.1 Allgemeine Auswirkungen in der Gesellschaft	9\r\n" + 
				"4.2 Politische Auswirkungen manipulativer Instrumente in der Gesellschaft…………………………………………………………………….10\r\n" + 
				"5. Maßnahmen und Präventionen gegen Internet Manipulation	13\r\n" + 
				"6. Ausblick/Fazit	15\r\n" + 
				"Literaturverzeichnis………………………………………………………………..IV\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Inhaltsverzeichnis\r\n" + 
				"\r\n" + 
				"Abstract………………………………………………………………………………I\r\n" + 
				"Inhaltsverzeichnis…………………………………………………………………II\r\n" + 
				"1. Einleitung	4\r\n" + 
				"2. Begriffserklärung	5\r\n" + 
				"3. Instrumente für Internet Manipulation	6\r\n" + 
				"3.1 Social-Bots	6\r\n" + 
				"3.2 Echokammern und Filterblasen	7\r\n" + 
				"3.3 Microtargeting………………………………………………………………..8\r\n" + 
				"4. Auswirkung der Internet Manipulation	9\r\n" + 
				"4.1 Allgemeine Auswirkungen in der Gesellschaft	9\r\n" + 
				"4.2 Politische Auswirkungen manipulativer Instrumente in der Gesellschaft…………………………………………………………………….10\r\n" + 
				"5. Maßnahmen und Präventionen gegen Internet Manipulation	13\r\n" + 
				"6. Ausblick/Fazit	15\r\n" + 
				"Literaturverzeichnis………………………………………………………………..IV\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Wissenschaftliches Arbeiten und Recherchieren\r\n" + 
				"in\r\n" + 
				"Allgemeine Informatik (AIN 2)\r\n" + 
				"\r\n" + 
				"Wie wirkt sich Manipulation im Internet auf die   Gesellschaft aus?\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n"+ 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Wissenschaftliches Arbeiten und Recherchieren\r\n" + 
				"in\r\n" + 
				"Allgemeine Informatik (AIN 2)\r\n" + 
				"\r\n" + 
				"Wie wirkt sich Manipulation im Internet auf die   Gesellschaft aus?\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n"+ 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"Wissenschaftliches Arbeiten und Recherchieren\r\n" + 
				"in\r\n" + 
				"Allgemeine Informatik (AIN 2)\r\n" + 
				"\r\n" + 
				"Wie wirkt sich Manipulation im Internet auf die   Gesellschaft aus?\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n"+ 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n"+"sakjdaskjdlkasjhdlkashdlksahdlkhsalkhsaldhaslhdlakshsdlasdhldshsdlashddhaslkhdlksadhdaslkhdslkhsadlkdashdlskahdsalkhasdlkdsahldsahdsalhsdalgfgsdfsdfdsfsdfdsfsdfsdfsdfsdfsdfs"
				+"dsafdaslfjlsdggggffsadasdasdassdsdadasdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddad" + 
				"dddddddddddddddddddssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" + 
				"dassssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + 
				"sddjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"+"sakjdaskjdlkasjhdlkashdlksahdlkhsalkhsaldhaslhdlakshsdlasdhldshsdlashddhaslkhdlksadhdaslkhdslkhsadlkdashdlskahdsalkhasdlkdsahldsahdsalhsdalgfgsdfsdfdsfsdfdsfsdfsdfsdfsdfsdfs"
				+"dsafdaslfjlsdggggffsadasdasdassdsdadasdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddad" + 
				"dddddddddddddddddddssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" + 
				"dassssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + 
				"ddddddddddddddddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+
				"dddddddddddddddddddddddddddrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr";
		
		System.out.println(s.length());
		
		System.out.println(reverseRecursiv(s));
		

	}

}
