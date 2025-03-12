package Objekty;

import Mistnosti.Mistnost;
import Predmety.Kniha;
import Predmety.Predmet;

import java.io.IOException;
import java.util.ArrayList;

public class KnihovnaObj extends Objekt{

    private ArrayList<Kniha> knihy;
    public KnihovnaObj(String nazev, Mistnost polohaObjektu, Predmet predmet) {
        super(nazev, polohaObjektu,predmet);
        knihy = new ArrayList<>();
    }
    public void pridaniKnihy(Kniha kniha) throws IOException {
        kniha.nahraniStran(kniha.getNazev());
        knihy.add(kniha);
    }
    /*public void vypis() throws IOException {
        for(int i = 0;i<knihy.size();i++){
            knihy.get(i).nahraniStran(knihy.get(i).getNazev());
        }
    }*/

    public ArrayList<Kniha> getKnihy() {
        return knihy;
    }
}
