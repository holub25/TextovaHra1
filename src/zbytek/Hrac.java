package zbytek;

import Mistnosti.Mistnost;

public class Hrac {

    private String jmeno;
    private InventoryPlayer inventory;
    private Mistnost aktualniMistnost;

    public Hrac(String jmeno, InventoryPlayer inventory, Mistnost aktualniMistnost) {
        this.jmeno = jmeno;
        this.inventory = inventory;
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
        return null;
    }
}
