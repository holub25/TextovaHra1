package Commands;

import zbytek.Hra;

public class Zpet implements Command{
    private Hra hra;

    public Zpet(Hra hra) {
        this.hra = hra;
    }

    /**
     * Tato metoda hráči zruší stav prozkoumávání nebo čtení.
     * @param vstup není třeba zde.
     * @return potvrdí konec prozkoumávání a čtení.
     */

    @Override
    public String prikaz(String vstup) {
        hra.getHrac().setPruzkum(false);
        hra.getHrac().setProzObjekt(null);
        hra.getHrac().setCte(false);
        hra.getHrac().setCtenaKniha(null);
        return "Prestal jste prozkoumavat ";
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
