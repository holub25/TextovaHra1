package zbytek;

import Predmety.Predmet;

import java.util.ArrayList;

public class InventoryPlayer {
    private ArrayList<Predmet> predmety;
    private int velikost;

    public InventoryPlayer(ArrayList<Predmet> predmety, int velikost) {
        this.predmety = predmety;
        this.velikost = velikost;
    }

    public void pridaniPredmetu(Predmet predmet){
        predmety.add(predmet);
    }
    public void odebraniPredmetu(Predmet predmet){
        predmety.remove(predmet);
    }
}
