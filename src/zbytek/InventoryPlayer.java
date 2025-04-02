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

    /**
     * Metoda která zkontroluje zda je inventář již plný nebo ne.
     * @return vratí zda je plný čí nikoliv.
     */
    public boolean kontrolaVelikosti(){
        if(predmety.size()==velikost){
            return false;
        }
        return true;
    }

    /**
     * Přidá předmět do arrayListu.
     * @param predmet předmět který má být přidán.
     */
    public void pridaniPredmetu(Predmet predmet){
        predmety.add(predmet);
    }
    /**
     * Odebere předmět z arrayListu.
     * @param predmet předmět který má být odebrán.
     */
    public void odebraniPredmetu(Predmet predmet){
        predmety.remove(predmet);
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }


    @Override
    public String toString() {
        return "Predmety v inv- "+predmety;
    }
}
