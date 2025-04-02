package Commands;

import zbytek.Hra;

public class Informace implements Command{
    private Hra hra;

    public Informace(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(String vstup) throws Exception {
        return "Nazev: "+hra.getMomentalniMistnost().getNazev()+"\n"+hra.getMomentalniMistnost().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public boolean povoleniPruz() {
        return false;
    }

    @Override
    public boolean cteni() {
        return false;
    }
}
