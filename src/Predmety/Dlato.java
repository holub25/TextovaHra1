package Predmety;

import Mistnosti.Mistnost;
import zbytek.Hra;

public class Dlato extends Predmet{
    private Hra hra;
    public Dlato(String nazev, Mistnost poloha, boolean sebrana) {
        super(nazev, poloha, sebrana);
    }

    public Hra getHra() {
        return hra;
    }

    public void setHra(Hra hra) {
        this.hra = hra;
    }

    public String pouzitDlata(){
        for(int b = 0;b<hra.getHrac().getInventory().getPredmety().size();b++){
            if(hra.getHrac().getInventory().getPredmety().get(b).getNazev().equalsIgnoreCase("Omitka")){
                return "Již omítku máš";
            }
        }
        hra.getHrac().getInventory().pridaniPredmetu(new Omitka("Omitka",hra.getMomentalniMistnost(),false));
        return "Zíksla si omítku";
    }
}
