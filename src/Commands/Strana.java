package Commands;

import zbytek.Hra;

public class Strana implements Command{
    private Hra hra;

    public Strana(Hra hra) {
        this.hra = hra;
    }

    /**
     * Tato metoda pouze přetočí stránku knihy.
     * @param vstup je buď + nebo -.
     * @return vrátí danou stránku podle vstupu.
     */

    @Override
    public String prikaz(String vstup) {
        return hra.getHrac().getCtenaKniha().zobrazeniStrany(vstup,hra.getHrac());
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public boolean povoleniPruz() {
        return true;
    }

    @Override
    public boolean cteni() {
        return true;
    }
}
