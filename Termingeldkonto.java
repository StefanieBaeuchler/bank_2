package bank;

public class Termingeldkonto extends Geldeinlage{

    public Termingeldkonto(String iban, double kontostand, Kunde kunde, double zinssatz, int laufzeitMonat) {
        super(iban, kontostand, zinssatz, laufzeitMonat);
    }

    public Termingeldkonto(String iban, double kontostand,  double zinssatz, int laufzeitMonat) {
        super(iban, kontostand, zinssatz, laufzeitMonat);
    }

    @Override
    public void einzahlen(double betrag){
        System.out.println("Eine Einzahlung ist nicht moeglich");
    }

@Override
public double getPrognose(){
    double endkapital = this.kontostand* Math.pow((1 + this.zinssatz), this.laufzeitMonat/12);
    return endkapital;
}
}
