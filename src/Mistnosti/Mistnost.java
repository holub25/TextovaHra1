package Mistnosti;


import Objekty.Objekt;
import Postavy.Postava;
import Predmety.Dlato;
import Predmety.Predmet;

import java.util.ArrayList;

public abstract class Mistnost {
    protected String nazev;
    protected ArrayList<String> sousedniMistnosti;
    protected ArrayList<Predmet> predmetyVMistnosti;
    protected ArrayList<String> pouzitelnePredmety;

    protected Postava postava;
    protected Objekt objekt;

    public Mistnost(String nazev,ArrayList<String> sousedi) {
        this.nazev = nazev;
        this.sousedniMistnosti = new ArrayList<>();
        this.predmetyVMistnosti = new ArrayList<>();
        this.pouzitelnePredmety = new ArrayList<>();
        setSousedniMistnosti(sousedi);
    }


    /**
     * Přidá předmět do místnosti.
     * @param predmet konkrétni předmět,
     */
    public void pridatPredmet(Predmet predmet){
        predmetyVMistnosti.add(predmet);
    }
    public void pridaniVicePredmetu(String[] predmety,Mistnost mistnost){
        for(int i = 0;i<predmety.length;i++){
            Dlato pr = new Dlato("j",null,false);
            if(pr.zvoleniPredmetu(predmety[i],mistnost)!=null){
                predmetyVMistnosti.add(pr.zvoleniPredmetu(predmety[i],mistnost));
            }
        }
    }

    /**
     * Nastaví postavu v místnosti.
     * @param postava postava která se ma dát do místnosti.
     */
    public void pridatPostavu(Postava postava){
        this.postava = postava;
    }

    /**
     * Přidá knokrétní objekt do místnosti.
     * @param objekt je objekt který se má přidat.
     */
    public void pridatObjekt(Objekt objekt){
        this.objekt = objekt;
    }

    /**
     * Odebere předmět z místnosti.
     * @param predmet je předmět který se má odebrat.
     */
    public void odebratPredmet(Predmet predmet){
        predmetyVMistnosti.remove(predmet);
    }
    /*public void pokusvypis(){
        for(int i = 0;i<predmetyVMistnosti.size();i++){
            System.out.println(predmetyVMistnosti.get(i));
        }
    }*/

    /**
     * Nastaví který předmět se dá v místnosti použít.
     * @param list je název použitelných předmětu.
     */
    public void pridatPouzitelnePred(String[] list){
        for(int i =0;i<list.length;i++){
            pouzitelnePredmety.add(list[i]);
        }
    }

    public ArrayList<String> getPouzitelnePredmety() {
        return pouzitelnePredmety;
    }


    @Override
    public String toString() {
        String postava1 = "Nikdo";
        String objekt1 = "Žádný";

        if(objekt!=null){
            objekt1 = objekt.getNazev();
        }if (postava!=null) {
            postava1 = postava.getJmeno();
        }
        return "V mistnosti se nachází "+predmetyVMistnosti+"\nJe zde "+postava1+"\nA objekt "+objekt1;
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
