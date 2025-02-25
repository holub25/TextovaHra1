package Mistnosti;

import java.util.ArrayList;

public abstract class Mistnost {
    protected String nazev;
    protected ArrayList<String> sousedniMistnosti;

    public Mistnost(String nazev) {
        this.nazev = nazev;
        this.sousedniMistnosti = new ArrayList<>();
    }

    public void pridatSouseda(String nazevMistnosti){
        this.sousedniMistnosti.add(nazevMistnosti);
    }
}
