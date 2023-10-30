package bank;

import java.util.Arrays;
import java.util.List;

public class Firmenkunde extends Kunde{

    protected String firmenname;

    public Firmenkunde(List<Konto> konten, String firmenname) {
        super(konten);
        this.firmenname = firmenname;
    }

    public Firmenkunde(String firmenname) {
        super(Arrays.asList());
        this.firmenname = firmenname;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }
}
