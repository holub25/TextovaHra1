package Postavy;

import Mistnosti.Mistnost;

public abstract class Postava {
    protected String jmeno;
    protected Mistnost poloha;
    protected String text;
    protected int faze;

    public Postava(String jmeno, Mistnost poloha,int faze) {
        this.jmeno = jmeno;
        this.poloha = poloha;
        this.faze = faze;
        this.text = nahraniTextu();
    }

    public void zmenaFaze(){
        this.faze = faze+1;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public Mistnost getPoloha() {
        return poloha;
    }

    public void setPoloha(Mistnost poloha) {
        this.poloha = poloha;
    }


    public int getFaze() {
        return faze;
    }

    public void setFaze(int faze) {
        this.faze = faze;
    }

    public String nahraniTextu(){
        return null;
    }
}
