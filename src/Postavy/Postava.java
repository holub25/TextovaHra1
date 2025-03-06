package Postavy;

import Mistnosti.Mistnost;

public abstract class Postava {
    protected String jmeno;
    protected Mistnost poloha;
    protected String popis;
    protected String text;
    protected int faze;

    public Postava(String jmeno, Mistnost poloha,String popis,int faze) {
        this.jmeno = jmeno;
        this.poloha = poloha;
        this.popis = popis;
        this.faze = faze;
        this.text = nahraniTextu();
    }

    public String komunikace(){
        return null;
    }
    public String nahraniPopisu(){
        return null;
    }
    public String nahraniTextu(){
        return null;
    }
}
