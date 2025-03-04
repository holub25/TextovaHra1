package Predmety;

import Mistnosti.Mistnost;

import java.util.HashMap;

public class Klice extends Predmet {

    private HashMap<String,String> slova;

    public Klice(String nazev, Mistnost poloha, boolean sebrana) {
        super(nazev, poloha, sebrana);
    }

    public boolean hadankaKlic(){
        return true;
    }
    public void nahraniSlov(){

    }
}
