import javax.swing.*;

public class TestMain {

    public static void main(String[] args){
            Bauteil Akku = new Bauteil("Akkus");
            Bauteil Grafikkarten = new Bauteil("Grafikkarten");
            Bauteil Netzwerkadapter = new Bauteil("Netzwerkadapter");
            Bauteil Prozessoren = new Bauteil("Prozessoren");
            Bauteil Computer = new Bauteil("Computer");
            Bauteil Systemgeraete = new Bauteil("Systemgeraete");
            Bauteil ExterneAkkus = new Bauteil("ExterneAkkus");
            Bauteil ExterneAkkus2 = new Bauteil("ExterneAkkus2");
            Bauteil ExterneAkkus3 = new Bauteil("ExterneAkkus3");
            Bauteil ExterneAkkus4 = new Bauteil("ExterneAkkus4");
            //Teil Akku
            Teil ACPI = new Teil("Microsoft ACPI");
            Teil Netzteil = new Teil("Microsoft-Netzteil");
            //Teil Externe Akkus
            Teil Akku1 = new Teil("Akku1");
            Teil Akku2 = new Teil("Akku2");
            Teil Akku3 = new Teil("Akku3");
            Teil Akku4 = new Teil("Akku4");
            Teil Akku5 = new Teil("Akku5");
            //Teil GRAKA
            Teil Intel = new Teil("INTEL(R) HD Graphics 4600");
            Teil Nvidia = new Teil("NVIDIA GeForce GTX 850");
            Teil Kern = new Teil("XF-4990xt");
            //Teil Netzwerk
            Teil Lan = new Teil("802.11ac-Drahtlos-Lan-Karte");
            Teil PCIe = new Teil("Realtek PCIe GBE Family Controller");
            //Teil PRozessor
            Teil Core = new Teil("INTEL(R) Core(TM) i7-59900HQ CPU @ 3.70GHz");
            Teil Core1 = new Teil("Ryzen 3600X");
            Teil Core2 = new Teil("Ryzen 3700X");
            Teil Core3 = new Teil("Ryzen 3600");
            Teil Core4 = new Teil("Ryzen 2600");
            //Teil Systemgeraete 
            Teil luefter = new Teil("ACPI-Lüfter");
            Teil luefter1 = new Teil("ACPI-Schalter");
            Teil luefter2 = new Teil("ACPI-Thermozone");
            Teil luefter3 = new Teil("DMA-Controller");
            Teil luefter4 = new Teil("Legacygerät");
            
            Computer.add(Akku);
            //Computer.add(Grafikkarten);
          
            Akku.add(ACPI);
            Akku.add(Netzteil);

            Akku.add(ExterneAkkus);
            ExterneAkkus.add(Akku1);
            ExterneAkkus.add(ExterneAkkus2);
            ExterneAkkus2.add(Akku2);
            ExterneAkkus2.add(ExterneAkkus3);
            ExterneAkkus3.add(Akku4);
            ExterneAkkus3.add(ExterneAkkus4);
            ExterneAkkus4.add(Akku5);
           
            Computer.add(Netzwerkadapter);
            Computer.add(Prozessoren);
            Prozessoren.add(Core);
            Prozessoren.add(Core1);
            Prozessoren.add(Core2);
            Prozessoren.add(Core3);
            Prozessoren.add(Core4);
            Prozessoren.add(Systemgeraete);
            
            Grafikkarten.add(Intel);
            //Intel.add(Kern);
            Grafikkarten.add(Nvidia);

            Netzwerkadapter.add(Lan);
            Netzwerkadapter.add(PCIe);

            Systemgeraete.add(luefter);
            Systemgeraete.add(luefter1);
            Systemgeraete.add(luefter2);
            Systemgeraete.add(luefter3);
            Systemgeraete.add(luefter4);
            System.out.println("---------------------GerÃ¤te-Manager----------------------------");
           
            PrintVisitor printVisitor = new PrintVisitor();
            InformationsVisitor informationsVisitor = new InformationsVisitor();
            
            
            System.out.println(printVisitor.visit(Computer));
            
            informationsVisitor.visit(Computer);
            informationsVisitor.ergebnis();
            
            
            //Computer.print("\t");
    }
}
