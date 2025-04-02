package Commands;

import Mistnosti.Sklep;
import Objekty.Rozeznavatel;
import Predmety.*;
import zbytek.Hra;

import java.io.IOException;

public class Pouzit implements Command {
    private Hra hra;

    public Pouzit(Hra hra) {
        this.hra = hra;
    }

    /**
     * Umožní hráči použít daný předmět v místnosti, když je to možné.
     * @param vstup název předmětu který chce hráč použít.
     * @return vypíše akci použitého předmětu nebo možnou chybu.
     * @throws IOException
     */
    @Override
    public String prikaz(String vstup) throws Exception {
        for(int i = 0;i<hra.getMomentalniMistnost().getPouzitelnePredmety().size();i++){
            if(hra.getMomentalniMistnost().getPouzitelnePredmety().get(i).equalsIgnoreCase(vstup)){
                for(int b = 0;b<hra.getHrac().getInventory().getPredmety().size();b++){
                    if(hra.getHrac().getInventory().getPredmety().get(b).getNazev().equalsIgnoreCase(vstup)){
                        return pouzitelnePredmety(vstup,b);
                    }
                }
                return "Předmět nemáte u sebe";
            }
        }
        for(int i = 0;i<hra.getMomentalniMistnost().getObjekt().getPouzitelnePredmety().size();i++){
            if(hra.getMomentalniMistnost().getObjekt().getPouzitelnePredmety().get(i).equalsIgnoreCase(vstup)){
                for(int b = 0;b<hra.getHrac().getInventory().getPredmety().size();b++){
                    if(hra.getHrac().getInventory().getPredmety().get(b).getNazev().equalsIgnoreCase(vstup)){
                        return pouzitelnePredmety(vstup,b);
                    }

                }
                return "Předmět nemáte u sebe";
            }
        }
        return "Předmět zde nemůžete použít";
    }

    /**
     * Metoda která zachytí předměty které se dají použít.
     * @param vstup název předmětu
     * @param i index předmětu v inventáři.
     * @return navrátí akci použitého předmětu.
     * @throws Exception
     */
    public String pouzitelnePredmety(String vstup,int i) throws Exception {
        String odpoved = "";
        Predmet predmet = hra.getHrac().getInventory().getPredmety().get(i);
        if(vstup.equalsIgnoreCase("klice")){
            if(predmet instanceof Klice klice){
                for(int b = 0; b<hra.getSvet().getMistnosti().size(); b++){
                    if(hra.getSvet().getMistnosti().get(b) instanceof Sklep sklep){
                        sklep.setUzamcen(klice.hadankaKlic());
                        if(sklep.isUzamcen() == false){
                            odpoved = "Odemkl jste sklep";
                        }else {
                            odpoved = "sklep jset neodemkl";
                        }
                    }
                }
            }
        } else if (vstup.equalsIgnoreCase("prasky")||vstup.equalsIgnoreCase("houby")||vstup.equalsIgnoreCase("omitka")) {
            if(predmet.getNazev().equalsIgnoreCase(vstup)){
                if(hra.getHrac().isPruzkum()&&hra.getHrac().getProzObjekt() instanceof Rozeznavatel rozeznavatel){
                    odpoved = rozeznavatel.rozpoznatLatku(vstup,hra.getHrac());
                }
            }
        } else if (vstup.equalsIgnoreCase("dlato")) {
            if(predmet instanceof Dlato dlato){
                odpoved = dlato.pouzitDlata();
            }
        } else if(vstup.equalsIgnoreCase("lopata")){
            if(predmet instanceof Lopata lopata){
                odpoved = lopata.pouzitiLopata();
            }
        }
        return odpoved;
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
