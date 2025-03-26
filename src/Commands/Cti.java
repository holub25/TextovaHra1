package Commands;

import Objekty.KnihovnaObj;
import Objekty.Objekt;
import Objekty.Trezor;
import Predmety.Kniha;
import Predmety.Predmet;
import zbytek.Hra;

public class Cti implements Command{
    private Hra hra;

    public Cti(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda rozpozna zda se kniha nachází přímo v místnosti nebo v objektu. Zobrazí 1. stránku knihy.
     * @param vstup je název knihy ,kterou chce hráč číst.
     * @return Knihu kterou hráč chce číst (jestli tedy byla nalezena).
     */
    @Override
    public String prikaz(String vstup) {
        for(int i = 0;i<hra.getMomentalniMistnost().getPredmetyVMistnosti().size();i++){
            if(hra.getMomentalniMistnost().getPredmetyVMistnosti().get(i) instanceof Kniha && vstup.equalsIgnoreCase(hra.getMomentalniMistnost().getPredmetyVMistnosti().get(i).getNazev())){
                return ((Kniha) hra.getMomentalniMistnost().getPredmetyVMistnosti().get(i)).zobrazeniStrany("+",hra.getHrac());
            }
        }
        Objekt objekt = hra.getMomentalniMistnost().getObjekt();
        return objektyKniha(objekt,vstup);
    }

    /**
     * Zobrazí knihy z objektů.
     * @param objekt je objekt z místnosti ve ketré se hráč nachází.
     * @param vstup je název knihy.
     * @return Buď vrátí nalezenou knihu nebo vypíše že kniha byla nenalezena.
     */

    public String objektyKniha(Objekt objekt,String vstup){
        if(objekt instanceof KnihovnaObj knihovna){
            for(int i = 0;i<knihovna.getKnihy().size();i++){
                if(hra.getHrac().isPruzkum() == true && vstup.equalsIgnoreCase(knihovna.getKnihy().get(i).getNazev())){
                    hra.getHrac().setCte(true);
                    hra.getHrac().setCtenaKniha(knihovna.getKnihy().get(i));
                    otevreniInformaci(((KnihovnaObj) objekt).getKnihy().get(i));
                    return knihovna.getKnihy().get(i).zobrazeniStrany("+",hra.getHrac());
                }
            }
        }
        else {
            for (int i = 0;i<objekt.getPredmetyVObjektu().size();i++){
                if(objekt.getPredmetyVObjektu().get(i) instanceof Kniha kniha && objekt.getPredmetyVObjektu().get(i).getNazev().equalsIgnoreCase(vstup)){
                    hra.getHrac().setCte(true);
                    hra.getHrac().setCtenaKniha(kniha);
                    otevreniInformaci(objekt.getPredmetyVObjektu().get(i));
                    return kniha.zobrazeniStrany("+",hra.getHrac());
                }
            }
        }
        return "Kniha nenalezena";
    }

    /**
     * Tato metoda otevírá hráči v určité fázi pokračování pro dokončení hry.
     * @param predmet je kniha kterou hráč musí otevřít pro pokračování.
     */
    public void otevreniInformaci(Predmet predmet){
        if(predmet.getNazev().equalsIgnoreCase("denik")&&hra.getHrac().getFazeHrace()==4){
            hra.getHrac().zvyseniFazeHrac();
        }else if(predmet.getNazev().equalsIgnoreCase("kniha2")&&hra.getHrac().getFazeHrace()==6){
            hra.getHrac().zvyseniFazeHrac();
        }
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
