package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;

import java.util.ArrayList;

public class Trezor extends Objekt{

    private int kod;
    public Trezor(String nazev, Mistnost polohaObjektu,Predmet predmet) {
        super(nazev, polohaObjektu,predmet);
    }

    public String otevreniTrezoru(){
        return null;
    }
}
