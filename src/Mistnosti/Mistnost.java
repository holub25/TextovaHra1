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
    public void pridatPredmet(Predmet predmet){
        predmetyVMistnosti.add(predmet);
    }
    public void pridatPostavu(Postava postava){
        this.postava = postava;
    }
    public void pridatObjekt(Objekt objekt){
        this.objekt = objekt;
    }
    public void odebratPredmet(Predmet predmet){
        predmetyVMistnosti.remove(predmet);
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

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public ArrayList<Predmet> getPredmetyVMistnosti() {
        return predmetyVMistnosti;
    }

    public void setPredmetyVMistnosti(ArrayList<Predmet> predmetyVMistnosti) {
        this.predmetyVMistnosti = predmetyVMistnosti;
    }

    public Postava getPostava() {
        return postava;
    }

    public void setPostava(Postava postava) {
        this.postava = postava;
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
