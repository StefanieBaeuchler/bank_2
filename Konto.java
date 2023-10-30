package bank;

public class Konto {

    protected String iban;
    protected double kontostand;
    protected Kunde kunde;


    public Konto(String iban, double kontostand, Kunde kunde) {
        this.iban = iban;
        this.kontostand = kontostand;
        this.kunde = kunde;
    }

    public Konto(String iban, double kontostand) {
        this.iban = iban;
        this.kontostand = kontostand;
    }

    public void einzahlen(double betrag){
    this.kontostand += betrag;
    }

    public void ausnzahlen(double betrag){
        this.kontostand -= betrag;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
