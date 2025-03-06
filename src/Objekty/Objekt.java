package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;

import java.util.ArrayList;

public abstract class Objekt {
    protected String nazev;
    protected ArrayList<Predmet> predmetyVObjektu;
    protected Mistnost polohaObjektu;

    public Objekt(String nazev, Mistnost polohaObjektu) {
        this.nazev = nazev;
        this.predmetyVObjektu = new ArrayList<>();
        this.polohaObjektu = polohaObjektu;
    }

    public void pridatPredmet(Predmet predmet){
        predmetyVObjektu.add(predmet);
    }
}
