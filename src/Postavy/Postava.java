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

    /**
     * Metoda ktera zvolí jaká postava má být vytvořena.
     * @param jmeno je jméno postavy
     * @param mistnost je místnost kde se ma postava nacházet.
     * @return vrátí danou postavu
     */
    public Postava zvoleniPostavy(String jmeno,Mistnost mistnost){
        switch (jmeno){
            case "morgan":
                return new Morgan(jmeno,mistnost,1);
            case "ben":
                return new Ben(jmeno,mistnost,1);
            case "elenora":
                return new Elenora(jmeno,mistnost,1);
            case "jack":
                return new Jack(jmeno,mistnost,1);
            case "alfred":
                return new Alfred(jmeno,mistnost,1);
            case "anna":
                return new Anna(jmeno,mistnost,1);
            case "stuart":
                return new Stuart(jmeno,mistnost,1);
        }
        return null;
    }

    /**
     * Zvětší fázi postavy o 1 bod.
     */
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
