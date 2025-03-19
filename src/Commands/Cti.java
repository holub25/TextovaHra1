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

    public String objektyKniha(Objekt objekt,String vstup){
        if(objekt instanceof KnihovnaObj knihovna){
            for(int i = 0;i<knihovna.getKnihy().size();i++){
                if(hra.getHrac().isPruzkum() == true && vstup.equalsIgnoreCase(knihovna.getKnihy().get(i).getNazev())){
                    hra.getHrac().setCte(true);
                    hra.getHrac().setCtenaKniha(knihovna.getKnihy().get(i));
                    return knihovna.getKnihy().get(i).zobrazeniStrany("+",hra.getHrac());
                }
            }
        }
        else {
            for (int i = 0;i<objekt.getPredmetyVObjektu().size();i++){
                if(objekt.getPredmetyVObjektu().get(i) instanceof Kniha kniha && objekt.getPredmetyVObjektu().get(i).getNazev().equalsIgnoreCase(vstup)){
                    hra.getHrac().setCte(true);
                    hra.getHrac().setCtenaKniha(kniha);
                    System.out.println("JDE");
                    otevreniInformaci(objekt.getPredmetyVObjektu().get(i));
                    System.out.println("FAZE HRACE: "+hra.getHrac().getFazeHrace());
                    System.out.println("FAZE Postav" + hra.getSvet().getMistnosti().get(1).getPostava().getFaze());
                    return kniha.zobrazeniStrany("+",hra.getHrac());
                }
            }
        }
        return "Kniha nenalezena";
    }
    public void otevreniInformaci(Predmet predmet){
        if(predmet.getNazev().equalsIgnoreCase("denik")&&hra.getHrac().getFazeHrace()==4){
            hra.getHrac().zvyseniFazeHrac();
            System.out.println(hra.getHrac().getFazeHrace());
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
