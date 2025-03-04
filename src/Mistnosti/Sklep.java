package Mistnosti;

import java.util.ArrayList;

public class Sklep extends Mistnost{

    private boolean uzamcen;
    public Sklep(String nazev, ArrayList<String> sousedi) {
        super(nazev,sousedi);
        this.uzamcen = true;
    }
    public String odemknout(){
        return null;
    }

}
