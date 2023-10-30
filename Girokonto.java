package bank;

public class Girokonto extends Konto {

    protected double disporahmen;

    public Girokonto(String iban, double kontostand, Kunde kunde, double disporahmen) {
        super(iban, kontostand, kunde);
        this.disporahmen = disporahmen;
    }

    public Girokonto(String iban, double kontostand, double disporahmen) {
        super(iban, kontostand);
        this.disporahmen = disporahmen;
    }

    @Override
    public void ausnzahlen(double betrag) {
        if ((this.kontostand - betrag) < this.disporahmen) {
    System.out.print("Der Betrag ist zu hoch.");
        }
        this.kontostand -= betrag;
    }

    public double getDisporahmen() {
        return disporahmen;
    }

    public void setDisporahmen(double disporahmen) {
        this.disporahmen = disporahmen;
    }
}
