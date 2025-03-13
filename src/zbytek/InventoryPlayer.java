package zbytek;

import Predmety.Predmet;

import java.util.ArrayList;

public class InventoryPlayer {
    private ArrayList<Predmet> predmety;
    private int velikost;

    public InventoryPlayer(int velikost) {
        this.predmety = new ArrayList<>();
        this.velikost = velikost;
    }
    public boolean kontrolaVelikosti(){
        if(predmety.size()==velikost){
            return false;
        }
        return true;
    }

    public void pridaniPredmetu(Predmet predmet){
        predmety.add(predmet);
    }
    public void odebraniPredmetu(Predmet predmet){
        predmety.remove(predmet);
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }

    public int getVelikost() {
        return velikost;
    }

    @Override
    public String toString() {
        return "InventoryPlayer{" +
                "predmety=" + predmety +
                '}';
    }
}
