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

    /**
     * Přidá do knihovny jednotlivé knihy.
     * @param knizky je kniha která se má přidat do arrayListu.
     * @throws IOException
     */
    /*public void pridaniKnihy(Kniha kniha) throws IOException {
        kniha.nahraniStran(kniha.getNazev());
        knihy.add(kniha);
    }*/
    public void pridaniKnihy(String[] knizky,Mistnost mistnost) throws IOException {
        for(int i = 0;i<knizky.length;i++){
            if(i>0&&knihy.size()<3){
                knihy.add(new Kniha(knizky[i],mistnost,false));
            }
        }
        nahraniKnih();
    }
    public void nahraniKnih() throws IOException {
        for(int i = 0;i<knihy.size();i++){
            knihy.get(i).nahraniStran(knihy.get(i).getNazev());
        }
    }

    public ArrayList<Kniha> getKnihy() {
        return knihy;
    }
}
