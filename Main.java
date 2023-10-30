package bank;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<Konto> konten = new ArrayList<>();
    private static List<Kunde> kunden = new ArrayList<>();

    public static void main(String[] args) {
        initDemoData();

        System.out.printf("KUNDEN\n");
        printKunden(kunden);
        System.out.printf("KONTEN\n");
        printKonten(konten);
        System.out.printf("HOECHSTER KONTOSTAND\n");
        printKonto(getKontoMitKoechstenKontostand());

    }

    public static void printKonten(List<Konto> konten) {
        for(Konto k : konten){
            printKonto(k);
        }

    }

    public static void printKonto(Konto konto) {
        if (konto instanceof Girokonto) {
            System.out.printf("%s (%s), Kontostand: %.1f",
                    konto.getIban(),
                    konto.getClass().getSimpleName(),
                    konto.getKontostand()
            );

        }
        if (konto instanceof Termingeldkonto) {
            System.out.printf("%s (%s), Kontostand: %.1f, Zinssatz: %.2f, Laufzeit: %d Monate, Prognose: %.2f",
                    konto.getIban(),
                    konto.getClass().getSimpleName(),
                    konto.getKontostand(),
                    ((Termingeldkonto) konto).getZinssatz(),
                    ((Termingeldkonto) konto).getLaufzeitMonat(),
                    ((Termingeldkonto) konto).getPrognose());
            System.out.println("\n");
        }
        if (konto instanceof Sparplankonto) {
            System.out.printf("%s (%s), Kontostand: %f, Zinssatz: %f, Laufzeit: %d Monate, Sparplan: %f monatlich, Prognose: %f",
                    konto.getIban(),
                    konto.getClass().getSimpleName(),
                    konto.getKontostand(),
                   ((Sparplankonto) konto).getZinssatz(),
                    ((Sparplankonto) konto).getLaufzeitMonat(),
                    ((Sparplankonto) konto).getSparbetragMonatlich(),
                    ((Sparplankonto) konto).getPrognose());
            System.out.println("\n");
        }
    }

    public static void printKunden(List<Kunde> kunden) {
        for (Kunde k : kunden) {
            printKunde(k);
        }

    }

    public static void printKunde(Kunde kunde) {
        if (kunde instanceof Privatkunde) {
            System.out.printf("%s %s: %d Konten: ",
                    ((Privatkunde) kunde).getVorname(),
                    ((Privatkunde) kunde).getNachname(),
                    kunde.getKonten().size()
            );
            for (Konto k : konten) {
                if (k.getKunde() == kunde) {
                    System.out.printf("%s (%s)",
                            k.getIban(), k.getClass().getSimpleName());
                }
            }
            System.out.println("\n");
        }

        if (kunde instanceof Firmenkunde) {
            System.out.printf("%s: %d Konten:",
                    ((Firmenkunde) kunde).getFirmenname(),
                    kunde.getKonten().size());
            for (Konto k : konten) {
                if (k.getKunde() == kunde) {
                    System.out.printf("%s (%s)", k.getIban(), k.getClass().getSimpleName());
                }
            }
            System.out.println("\n");
        }

    }

    public static Konto getKontoMitKoechstenKontostand() {
        Konto kontoMitHoechstemKontostand = konten.get(0);
        for (Konto k : konten) {
            if (k.getKontostand() > kontoMitHoechstemKontostand.kontostand) {
                kontoMitHoechstemKontostand = k;
            }
        }
        return kontoMitHoechstemKontostand;
    }

    public static void initDemoData() {

        Girokonto girokonto1 = new Girokonto("AT3840272", 3400, 1000);
        Girokonto girokonto2 = new Girokonto("AT38456272", 5000, 1000);
        Termingeldkonto termingeldkonto1 = new Termingeldkonto("AT534747934598", 32000, 3, 20);
        Termingeldkonto termingeldkonto2 = new Termingeldkonto("AT5346647934598", 10000, 2, 25);
        Sparplankonto sparplankonto1 = new Sparplankonto("AT56778898", 40000, 5, 23, 300);
        Sparplankonto sparplankonto2 = new Sparplankonto("AT567788008", 50000, 5, 12, 500);

        konten.add(girokonto1);
        konten.add(girokonto2);
        konten.add(termingeldkonto1);
        konten.add(termingeldkonto2);
        konten.add(sparplankonto1);
        konten.add(sparplankonto2);

        Privatkunde privatkunde1 = new Privatkunde("Silvia", "Berger");
        Privatkunde privatkunde2 = new Privatkunde("Toni", "Huber");
        Privatkunde privatkunde3 = new Privatkunde("Erich", "Karner");
        Firmenkunde firmenkunde1 = new Firmenkunde("Claudias Backshop");
        Firmenkunde firmenkunde2 = new Firmenkunde("Hertas Fussbalmerch");

        kunden.add(privatkunde1);
        kunden.add(privatkunde2);
        kunden.add(privatkunde3);
        kunden.add(firmenkunde1);
        kunden.add(firmenkunde2);

        privatkunde1.setKonten(Arrays.asList(girokonto1, sparplankonto1));
        privatkunde2.setKonten(Arrays.asList(girokonto2));
        privatkunde3.setKonten(Arrays.asList(sparplankonto1));
        firmenkunde1.setKonten(Arrays.asList(sparplankonto2, termingeldkonto1));
        firmenkunde2.setKonten(Arrays.asList(termingeldkonto2));

    }
}