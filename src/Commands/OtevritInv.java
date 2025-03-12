package Commands;

import zbytek.Hra;


public class OtevritInv implements Command{
    private Hra hra;

    public OtevritInv(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(String vstup) {
        return ""+hra.getHrac().getInventory().toString();
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
