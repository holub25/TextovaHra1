package Mistnosti;


import Predmety.Predmet;

import java.util.ArrayList;

public abstract class Mistnost {
    protected String nazev;
    protected ArrayList<String> sousedniMistnosti;
    protected ArrayList<Predmet> predmetyVMistnosti;

    public Mistnost(String nazev,ArrayList<String> sousedi) {
        this.nazev = nazev;
        this.sousedniMistnosti = new ArrayList<>();
        this.predmetyVMistnosti = new ArrayList<>();
        setSousedniMistnosti(sousedi);
    }

    @Override
    public String toString() {
        return "Mistnost{" +
                "nazev='" + nazev + '\'' +
                ", sousedniMistnosti=" + sousedniMistnosti +
                '}';
    }
    public void setSousedniMistnosti(ArrayList<String> sousedniMistnosti) {
        this.sousedniMistnosti = sousedniMistnosti;
    }

    public String getNazev() {
        return nazev;
    }

    public ArrayList<String> getSousedniMistnosti() {
        return sousedniMistnosti;
    }

}
