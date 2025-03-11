package Commands;

import zbytek.Hra;

public class Prozkoumat implements Command{
    private Hra hra;

    public Prozkoumat(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(Object vstup) {
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
