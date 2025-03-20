package Commands;

import Commands.Command;
import Mistnosti.Mistnost;
import Mistnosti.Sklep;
import zbytek.Hra;
import zbytek.Svet;


public class Jdi implements Command {

    private Hra hra;
    private Svet svet;

    public Jdi(Hra hra, Svet svet) {
        this.hra = hra;
        this.svet = svet;
    }
    @Override
    public String prikaz(String nazev) {
        Mistnost aktualniMistnost = hra.getMomentalniMistnost();
        for (int i = 0; i < svet.getMistnosti().size(); i++) {
            Mistnost mistnost = svet.getMistnosti().get(i);
            if (mistnost.getNazev().equalsIgnoreCase(nazev)) {
                if(mistnost instanceof Sklep sklep && aktualniMistnost.getSousedniMistnosti().contains(mistnost.getNazev())){
                    if(sklep.isUzamcen()){
                        if(hra.getHrac().getFazeHrace()==3){
                            if(hra.getPrikazy().get("mluv") instanceof Mluv mluv){
                                hra.getHrac().zvyseniFazeHrac();
                            }
                        }
                        return "Sklep je uzamcen";
                    }
                }
                if (aktualniMistnost.getSousedniMistnosti().contains(mistnost.getNazev())) {
                    hra.setMomentalniMistnost(mistnost);
                    return "Přešel jsi do " + nazev+"\n"+ mistnost.toString();
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

    @Override
    public boolean povoleniPruz() {
        return false;
    }

    @Override
    public boolean cteni() {
        return false;
    }
}
