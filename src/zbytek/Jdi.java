package zbytek;

import Commands.Command;
import Mistnosti.Mistnost;


public class Jdi implements Command {

    private Hra hra;
    private Svet svet;

    public Jdi(Hra hra, Svet svet) {
        this.hra = hra;
        this.svet = svet;
    }
    @Override
    public String prikaz(Object nazev) {
        Mistnost aktualniMistnost = hra.getMomentalniMistnost();
        for (int i = 0; i < svet.getMistnosti().size(); i++) {
            Mistnost mistnost = svet.getMistnosti().get(i);
            if (mistnost.getNazev().equalsIgnoreCase((String) nazev)) {
                if (aktualniMistnost.getSousedniMistnosti().contains(mistnost.getNazev())) {
                    hra.setMomentalniMistnost(mistnost);
                    return "Přešel jsi do " + nazev;

                } else {
                    return "Nemůžete do této místnosti, nejsou propojené.";
                }
            }
        }
        return "Špatně zadaný příkaz.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
