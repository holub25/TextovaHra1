package zbytek;

import Mistnosti.Mistnost;
import Objekty.Objekt;

import java.util.Scanner;

public class Hrac {

    private String jmeno;
    private InventoryPlayer inventory;
    private Mistnost aktualniMistnost;
    private boolean pruzkum;
    private Objekt prozObjekt;

    public Hrac(String jmeno, int velikostInv, Mistnost aktualniMistnost) {
        this.jmeno = jmeno;
        this.inventory = new InventoryPlayer(velikostInv);
        this.aktualniMistnost = aktualniMistnost;
        this.pruzkum = false;
    }

    public String getJmeno() {
        return jmeno;
    }



    public InventoryPlayer getInventory() {
        return inventory;
    }

    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setInventory(InventoryPlayer inventory) {
        this.inventory = inventory;
    }

    public void setAktualniMistnost(Mistnost aktualniMistnost) {
        this.aktualniMistnost = aktualniMistnost;
    }

    public boolean isPruzkum() {
        return pruzkum;
    }

    public void setPruzkum(boolean pruzkum) {
        this.pruzkum = pruzkum;
    }

    public Objekt getProzObjekt() {
        return prozObjekt;
    }

    public void setProzObjekt(Objekt prozObjekt) {
        this.prozObjekt = prozObjekt;
    }

    public String nastaveniJmena(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej jmeno: ");
        String jmeno = sc.nextLine();
        this.jmeno = jmeno;
        return "Vaše jmeno je: "+jmeno;
    }

}
