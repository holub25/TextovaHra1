package Commands;

import zbytek.Hra;

public class Vyhodit implements Command{
    private Hra hra;

    public Vyhodit(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda která vyhodí předmět z inventáře.
     * @param vstup název předmětu který chce hráč vyhodit.
     * @return vrátí zda byl předmět vyhozen nebo ne.
     * @throws Exception
     */
    @Override
    public String prikaz(String vstup) throws Exception {
        for(int i = 0;i<hra.getHrac().getInventory().getPredmety().size();i++){
            if(hra.getHrac().getInventory().getPredmety().get(i).getNazev().equalsIgnoreCase(vstup)){
                hra.getMomentalniMistnost().pridatPredmet(hra.getHrac().getInventory().getPredmety().get(i));
                hra.getHrac().getInventory().odebraniPredmetu(hra.getHrac().getInventory().getPredmety().get(i));
                return "Odebran "+vstup;
            }
        }
        return "Predmet nenalezen";
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
