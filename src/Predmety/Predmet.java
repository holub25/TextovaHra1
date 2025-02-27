package Predmety;

import Mistnosti.Mistnost;

public abstract class Predmet {
    protected String nazev;
    protected Mistnost poloha;
    protected boolean sebrana;

    public Predmet(String nazev, Mistnost poloha, boolean sebrana) {
        this.nazev = nazev;
        this.poloha = poloha;
        this.sebrana = sebrana;
    }
}
