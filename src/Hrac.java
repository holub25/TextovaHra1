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
}
