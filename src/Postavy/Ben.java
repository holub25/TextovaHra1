package Postavy;

import Mistnosti.Mistnost;
import Predmety.Klice;
import zbytek.Hra;

import java.util.HashMap;

public class Ben extends Postava{

    private Hra hra;
    public Ben(String jmeno, Mistnost poloha, int faze) {
        super(jmeno, poloha,  faze);
    }

    public void setHra(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda která dá hráči klíč, když se hráč zeptá bena na konkrétní otázku.
     */
    public void predaniKlice(){
        if(hra.getHrac().getInventory().getPredmety().size()==0){
            hra.getHrac().getInventory().pridaniPredmetu(new Klice("Klice",null,true));
        }else {
            for(int i = 0;i<hra.getHrac().getInventory().getPredmety().size();i++){
                if(hra.getHrac().getInventory().getPredmety().get(i).getNazev().equalsIgnoreCase("Klice")){
                    System.out.println("Klíče již máš");
                }else {
                    hra.getHrac().getInventory().pridaniPredmetu(new Klice("Klice",null,true));
                }
            }
        }
    }
}
