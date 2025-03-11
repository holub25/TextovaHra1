package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;

import java.util.ArrayList;

public class Rozeznavatel extends Objekt{
    public Rozeznavatel(String nazev, Mistnost polohaObjektu,Predmet predmet) {
        super(nazev, polohaObjektu,predmet);
    }

    public String rozeznatLatku(){
        return null;
    }
}
