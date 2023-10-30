package bank;

import java.util.ArrayList;
import java.util.List;

public class Kunde {

    protected List<Konto> konten;

    public Kunde(List<Konto> konten) {
        this.konten = konten;
    }



    public List<Konto> getKonten() {
        return konten;
    }

    public void setKonten(List<Konto> konten) {
        this.konten = konten;
    }
}
