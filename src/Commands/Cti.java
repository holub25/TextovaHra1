package Commands;

import Objekty.KnihovnaObj;
import Objekty.Objekt;
import Predmety.Kniha;
import zbytek.Hra;

public class Cti implements Command{
    private Hra hra;

    public Cti(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(String vstup) {
        for(int i = 0;i<hra.getMomentalniMistnost().getPredmetyVMistnosti().size();i++){
            if(hra.getMomentalniMistnost().getPredmetyVMistnosti().get(i) instanceof Kniha && vstup.equalsIgnoreCase(hra.getMomentalniMistnost().getPredmetyVMistnosti().get(i).getNazev())){
                return ((Kniha) hra.getMomentalniMistnost().getPredmetyVMistnosti().get(i)).zobrazeniStrany("+");
            }
        }
        Objekt objekt = hra.getMomentalniMistnost().getObjekt();
        if(objekt instanceof KnihovnaObj knihovna){
            for(int i = 0;i<knihovna.getKnihy().size();i++){
                if(hra.getHrac().isPruzkum() == true && vstup.equalsIgnoreCase(knihovna.getKnihy().get(i).getNazev())){
                    hra.getHrac().setCte(true);
                    hra.getHrac().setCtenaKniha(knihovna.getKnihy().get(i));
                    return knihovna.getKnihy().get(i).zobrazeniStrany("+");
                }
            }
        }
        return "Kniha nenalezena";
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
