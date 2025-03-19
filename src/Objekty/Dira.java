package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;

public class Dira extends Objekt{
    private boolean vykopana;
    public Dira(String nazev, Mistnost polohaObjektu, Predmet predmet) {
        super(nazev, polohaObjektu, predmet);
        this.vykopana = false;
    }

    public boolean isVykopana() {
        return vykopana;
    }

    public void setVykopana(boolean vykopana) {
        this.vykopana = vykopana;
    }
}
