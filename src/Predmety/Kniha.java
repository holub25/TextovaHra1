package Predmety;

import Commands.Strana;
import Mistnosti.Mistnost;

import java.util.HashMap;

public abstract class Kniha extends Predmet{

    protected HashMap<Integer, Strana> strany;
    protected String nazev;
    protected int pocetStran;
    public Kniha(String nazev, Mistnost poloha, boolean sebrana) {
        super(nazev, poloha, sebrana);
        this.strany = new HashMap<>();
    }

}
