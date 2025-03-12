package Commands;

import zbytek.Hra;

public class Strana implements Command{
    private Hra hra;

    public Strana(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(String vstup) {
        return hra.getHrac().getCtenaKniha().zobrazeniStrany(vstup);
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
