package zbytek;

import Mistnosti.Mistnost;

import java.util.Scanner;

public class Hrac {

    private String jmeno;
    private InventoryPlayer inventory;
    private Mistnost aktualniMistnost;

    public Hrac(String jmeno, int velikostInv, Mistnost aktualniMistnost) {
        this.jmeno = jmeno;
        this.inventory = new InventoryPlayer(velikostInv);
        this.aktualniMistnost = aktualniMistnost;
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

    public String nastaveniJmena(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej jmeno: ");
        String jmeno = sc.nextLine();
        this.jmeno = jmeno;
        return "Vaše jmeno je: "+jmeno;
    }

}
