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
