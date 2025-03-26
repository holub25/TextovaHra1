package zbytek;

import Mistnosti.Mistnost;
import Objekty.Objekt;
import Predmety.Kniha;

import java.util.Scanner;

public class Hrac {

    private String jmeno;
    private int fazeHrace;
    private InventoryPlayer inventory;
    private Mistnost aktualniMistnost;
    private boolean pruzkum;
    private boolean cte;
    private Kniha ctenaKniha;
    private Objekt prozObjekt;

    public Hrac(String jmeno, int velikostInv, Mistnost aktualniMistnost,int fazeHrace) {
        this.jmeno = jmeno;
        this.inventory = new InventoryPlayer(velikostInv);
        this.aktualniMistnost = aktualniMistnost;
        this.pruzkum = false;
        this.cte = false;
        this.fazeHrace = fazeHrace;
    }

    public String getJmeno() {
        return jmeno;
    }

    public int getFazeHrace() {
        return fazeHrace;
    }

    public void setFazeHrace(int fazeHrace) {
        this.fazeHrace = fazeHrace;
    }

    public boolean isCte() {
        return cte;
    }

    public void setCte(boolean cte) {
        this.cte = cte;
    }

    public Kniha getCtenaKniha() {
        return ctenaKniha;
    }

    public void setCtenaKniha(Kniha ctenaKniha) {
        this.ctenaKniha = ctenaKniha;
    }
    public void zvyseniFazeHrac(){
        this.setFazeHrace(this.getFazeHrace()+1);
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

    /*public String nastaveniJmena(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej jmeno: ");
        String jmeno = sc.nextLine();
        this.jmeno = jmeno;
        return "Vaše jmeno je: "+jmeno;
    }*/

}
