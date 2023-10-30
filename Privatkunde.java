package bank;

import java.util.Arrays;
import java.util.List;

public class Privatkunde extends Kunde{

    protected String vorname;
    protected String nachname;

    public Privatkunde(List<Konto> konten, String vorname, String nachname) {
        super(konten);
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Privatkunde(String vorname, String nachname) {
        super(Arrays.asList());
        this.vorname = vorname;
        this.nachname = nachname;
    }



    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}
