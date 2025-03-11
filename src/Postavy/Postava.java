package Postavy;

import Mistnosti.Mistnost;

public abstract class Postava {
    protected String jmeno;
    protected Mistnost poloha;
    protected String popis;
    protected String text;
    protected int faze;

    public Postava(String jmeno, Mistnost poloha,int faze) {
        this.jmeno = jmeno;
        this.poloha = poloha;
        this.faze = faze;
        this.text = nahraniTextu();
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

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFaze() {
        return faze;
    }

    public void setFaze(int faze) {
        this.faze = faze;
    }

    public String komunikace(){
        return null;
    }
    public String nahraniPopisu(){
        return "JJ";
    }
    public String nahraniTextu(){
        return null;
    }
}
