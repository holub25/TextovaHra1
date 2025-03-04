package Mistnosti;


import Objekty.Objekt;
import Postavy.Postava;
import Predmety.Predmet;

import java.util.ArrayList;

public abstract class Mistnost {
    protected String nazev;
    protected ArrayList<String> sousedniMistnosti;
    protected ArrayList<Predmet> predmetyVMistnosti;
    protected Postava postava;
    protected Objekt objekt;

    public Mistnost(String nazev,ArrayList<String> sousedi) {
        this.nazev = nazev;
        this.sousedniMistnosti = new ArrayList<>();
        this.predmetyVMistnosti = new ArrayList<>();
        setSousedniMistnosti(sousedi);
    }
    public void pridatPredmet(){

    }
    public void pridatPostavu(){

    }
    public void pridatObjekt(){

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

    public Objekt getObjekt() {
        return objekt;
    }

    public void setObjekt(Objekt objekt) {
        this.objekt = objekt;
    }

    public ArrayList<String> getSousedniMistnosti() {
        return sousedniMistnosti;
    }

}
