package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;

import java.util.ArrayList;

public abstract class Objekt {
    protected String nazev;
    protected ArrayList<Predmet> predmetyVObjektu;
    protected Mistnost polohaObjektu;

    public Objekt(String nazev, Mistnost polohaObjektu, Predmet predmet) {
        this.nazev = nazev;
        this.predmetyVObjektu = new ArrayList<>();
        this.polohaObjektu = polohaObjektu;
        this.predmetyVObjektu.add(predmet);
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public ArrayList<Predmet> getPredmetyVObjektu() {
        return predmetyVObjektu;
    }

    public void pridaniPredmetu(Predmet predmet){
        predmetyVObjektu.add(predmet);
    }

    public Mistnost getPolohaObjektu() {
        return polohaObjektu;
    }

    public void setPolohaObjektu(Mistnost polohaObjektu) {
        this.polohaObjektu = polohaObjektu;
    }

    public void pridatPredmet(Predmet predmet){
        predmetyVObjektu.add(predmet);
    }
}
