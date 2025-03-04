package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;

import java.util.ArrayList;

public abstract class Objekt {
    protected ArrayList<Predmet> predmetyVObjektu;
    protected Mistnost polohaObjektu;

    public Objekt(ArrayList<Predmet> predmetyVObjektu, Mistnost polohaObjektu) {
        this.predmetyVObjektu = predmetyVObjektu;
        this.polohaObjektu = polohaObjektu;
    }

    public void pridatPredmet(){

    }
}
