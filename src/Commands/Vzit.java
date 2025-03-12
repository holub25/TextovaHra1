package Commands;
import Mistnosti.Mistnost;
import Predmety.*;
import zbytek.Hra;
import zbytek.Hrac;


public class Vzit implements Command{

    private Hra hra;
    private Hrac hrac;

    public Vzit(Hra hra,Hrac hrac) {
        this.hra = hra;
        this.hrac = hrac;
    }

    @Override
    public String prikaz(Object vstup) {
         Mistnost aktualniMistnost = hra.getMomentalniMistnost();
         for(int i = 0;i<aktualniMistnost.getPredmetyVMistnosti().size();i++){
             System.out.println("KON");
             if(aktualniMistnost.getPredmetyVMistnosti().get(i).getNazev().equalsIgnoreCase((String) vstup)){
                 hrac.getInventory().pridaniPredmetu(aktualniMistnost.getPredmetyVMistnosti().get(i));
                 aktualniMistnost.odebratPredmet(aktualniMistnost.getPredmetyVMistnosti().get(i));
                 return "Sebral jsi "+vstup;
             }else {
                 return "V mistnosti není "+vstup;
             }
         }
        return "KON2";
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
