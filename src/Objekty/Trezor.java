package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;

import java.util.ArrayList;

public class Trezor extends Objekt{

    private int kod;
    public Trezor(ArrayList<Predmet> predmetyVObjektu, Mistnost polohaObjektu) {
        super(predmetyVObjektu, polohaObjektu);
    }

    public String otevreniTrezoru(){
        return null;
    }
}
