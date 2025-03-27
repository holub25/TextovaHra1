package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;
import zbytek.Hra;

import java.util.ArrayList;

public class Krb extends Objekt{
    private Hra hra;
    public Krb(String nazev, Mistnost polohaObjektu,Predmet predmet) {
        super(nazev, polohaObjektu,predmet);
    }

    public Hra getHra() {
        return hra;
    }

    public void setHra(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda která potvrdí že hráč může důkladněji prozkoumat krb.
     * @return
     */
    public boolean pruzkum(){
        if(hra.fazePostavy("Morgan")<4){
            return false;
        }else {
            return true;
        }
    }
}
