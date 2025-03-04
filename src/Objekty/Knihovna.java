package Objekty;

import Mistnosti.Mistnost;
import Predmety.Kniha;
import Predmety.Predmet;

import java.util.ArrayList;

public class Knihovna extends Objekt{

    private ArrayList<Kniha> knihy;
    public Knihovna(ArrayList<Predmet> predmetyVObjektu, Mistnost polohaObjektu) {
        super(predmetyVObjektu, polohaObjektu);
    }

    public void pridatKnihu(){

    }
}
