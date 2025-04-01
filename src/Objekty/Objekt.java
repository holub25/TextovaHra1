package Objekty;

import Mistnosti.Mistnost;
import Predmety.Dlato;
import Predmety.Predmet;
import zbytek.Svet;

import java.io.IOException;
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
     * @param pouyitelne je název použitelného předmětu.
     */
    public void pridatPozitelnePred(String[] pouyitelne){
        for(int i = 0;i<pouyitelne.length;i++){
            pouzitelnePredmety.add(pouyitelne[i]);
        }
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
    public Objekt zvoleniObjektu(String nazev, Mistnost mistnost, Svet svet) throws IOException {
        switch (nazev){
            case "krb":
                return new Krb("krb",mistnost,null);
            case "trezor":
                return new Trezor("trezor",mistnost,null,4444,false);
            case "rozeznavatel":
                return new Rozeznavatel("rozeznavatel",mistnost,null,svet);
            case "knihovna":
                return new KnihovnaObj("knihovna",mistnost,null);
            case "dira":
                return new Dira("dira",mistnost,null);
        }
        return null;
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
    public void pridatVicePredmetu(String[] predmety,Mistnost mistnost){
        for(int i = 0;i<predmety.length;i++){
            Dlato pr = new Dlato("j",null,false);
            if(pr.zvoleniPredmetu(predmety[i],mistnost)!=null){
                predmetyVObjektu.add(pr.zvoleniPredmetu(predmety[i],mistnost));
            }
        }

    }


}
