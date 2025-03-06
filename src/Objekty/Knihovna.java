package Objekty;

import Mistnosti.Mistnost;
import Predmety.Kniha;
import Predmety.Predmet;

import java.util.ArrayList;

public class Knihovna extends Objekt{

    private ArrayList<Kniha> knihy;
    public Knihovna(String nazev, Mistnost polohaObjektu) {
        super(nazev, polohaObjektu);
    }

    public void pridatKnihu(){

    }
}
