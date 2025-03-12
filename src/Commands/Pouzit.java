package Commands;

import zbytek.Hra;

public class Pouzit implements Command {
    private boolean prozkoumani;
    private Hra hra;

    public Pouzit(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(Object vstup) {
        return "JDE TO";
    }

    public boolean isProzkoumani() {
        return prozkoumani;
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
        return false;
    }
}
