package Objekty;

import Mistnosti.Mistnost;
import Predmety.Kniha;
import Predmety.Predmet;

import java.util.ArrayList;

public class KnihovnaObj extends Objekt{

    private ArrayList<Kniha> knihy;
    public KnihovnaObj(String nazev, Mistnost polohaObjektu, Predmet predmet) {
        super(nazev, polohaObjektu,predmet);
    }

    public void pridatKnihu(){

    }
}
