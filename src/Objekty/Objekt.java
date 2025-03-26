package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;

import java.util.ArrayList;

public abstract class Objekt {
    protected String nazev;
    protected ArrayList<Predmet> predmetyVObjektu;
    protected Mistnost polohaObjektu;
    protected ArrayList<String> pouzitelnePredmety;


    public Objekt(String nazev, Mistnost polohaObjektu, Predmet predmet) {
        this.nazev = nazev;
        this.predmetyVObjektu = new ArrayList<>();
        this.polohaObjektu = polohaObjektu;
        this.predmetyVObjektu.add(predmet);
        this.pouzitelnePredmety = new ArrayList<>();
    }

    /**
     * Nastaví který předmět se dá v objektu použít.
     * @param nazev je název použitelného předmětu.
     */
    public void pridatPozitelnePred(String nazev){
        pouzitelnePredmety.add(nazev);
    }


    public ArrayList<String> getPouzitelnePredmety() {
        return pouzitelnePredmety;
    }


    @Override
    public String toString() {
        if(this instanceof KnihovnaObj knihovnaObj){
            System.out.println("JDE");
            return "V "+nazev+" se nachází "+knihovnaObj.getKnihy();
        }else {
            return "V "+nazev+" se nachází "+predmetyVObjektu;
        }

    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public ArrayList<Predmet> getPredmetyVObjektu() {
        return predmetyVObjektu;
    }
    /**
     * Přidá knokrétní předmět do objektu.
     * @param predmet je předmět který se má přidat.
     */
    public void pridaniPredmetu(Predmet predmet){
        predmetyVObjektu.add(predmet);
    }
    /**
     * Odebere předmět z objektu.
     * @param predmet je předmět který se má odebrat.
     */
    public void odebratPredmet(Predmet predmet){
        predmetyVObjektu.remove(predmet);
    }


}
