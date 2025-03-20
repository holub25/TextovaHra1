package Mistnosti;


import Objekty.Objekt;
import Postavy.Postava;
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
    /*public void pokusvypis(){
        for(int i = 0;i<predmetyVMistnosti.size();i++){
            System.out.println(predmetyVMistnosti.get(i));
        }
    }*/
    public void pridatPouzitelnePred(String nazev){
        pouzitelnePredmety.add(nazev);
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
