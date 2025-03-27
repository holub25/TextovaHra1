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
    public Predmet zvoleniPredmetu(String nazev,Mistnost mistnost){
        switch (nazev){
            case "dlato":
                return new Dlato(nazev,mistnost,false);
            case "lopata":
                return new Lopata(nazev,mistnost,false);
            case "klice":
                return new Klice(nazev,mistnost,false);
            case "prasky":
                return new LahvickaFPrasky(nazev,mistnost,false);
            case "houby":
                return new LahvickaHouby(nazev,mistnost,false);
            case "omitka":
                return new Omitka(nazev,mistnost,false);
            case "null":
                return null;
        }
        return null;
    }

    public String getNazev() {
        return nazev;
    }

    public Mistnost getPoloha() {
        return poloha;
    }


    @Override
    public String toString() {
        return ""+nazev;
    }
}
