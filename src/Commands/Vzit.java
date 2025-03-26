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

    /**
     * Metoda která hráči umožní sebrat předmět buď přímo z místnosti nebo z objektu.
     * @param vstup název předmětu který chce hráč sebrat.
     * @return potvrdí zda hráč předmět sebral či ne.
     */
    @Override
    public String prikaz(String vstup) {
         Mistnost aktualniMistnost = hra.getMomentalniMistnost();
         for(int i = 0;i<aktualniMistnost.getPredmetyVMistnosti().size();i++){
             System.out.println("KON");
             if(aktualniMistnost.getPredmetyVMistnosti().size() == 0){
                 return "Mistnost je prázdná";
             }
             else if(aktualniMistnost.getPredmetyVMistnosti().get(i).getNazev().equalsIgnoreCase(vstup)){
                 if(hrac.getInventory().kontrolaVelikosti()){
                     hrac.getInventory().pridaniPredmetu(aktualniMistnost.getPredmetyVMistnosti().get(i));
                     aktualniMistnost.odebratPredmet(aktualniMistnost.getPredmetyVMistnosti().get(i));
                     return "Sebral jsi "+vstup;
                 }
                 return "Váš inventory je plný";
             }
         }
         for (int i = 0;i<aktualniMistnost.getObjekt().getPredmetyVObjektu().size();i++){
             System.out.println("KON");
             if(aktualniMistnost.getPredmetyVMistnosti().size() == 0){
                 return "Objekt je prázdná";
             }
             else if(aktualniMistnost.getObjekt().getPredmetyVObjektu().get(i).getNazev().equalsIgnoreCase(vstup)){
                 if(hrac.getInventory().kontrolaVelikosti()){
                     hrac.getInventory().pridaniPredmetu(aktualniMistnost.getObjekt().getPredmetyVObjektu().get(i));
                     aktualniMistnost.getObjekt().odebratPredmet(aktualniMistnost.getPredmetyVMistnosti().get(i));
                     return "Sebral jsi "+vstup;
                 }
                 return "Váš inventory je plný";
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
