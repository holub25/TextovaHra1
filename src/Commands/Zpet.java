package Commands;

import zbytek.Hra;

public class Zpet implements Command{
    private Hra hra;

    public Zpet(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(Object vstup) {
        hra.getHrac().setPruzkum(false);
        hra.getHrac().setProzObjekt(null);
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
}
