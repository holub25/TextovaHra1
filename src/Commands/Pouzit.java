package Commands;

import Mistnosti.Sklep;
import Objekty.Rozeznavatel;
import Predmety.Klice;
import Predmety.LahvickaFPrasky;
import Predmety.LahvickaHouby;
import Predmety.Predmet;
import zbytek.Hra;

import java.io.IOException;

public class Pouzit implements Command {
    private Hra hra;

    public Pouzit(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(String vstup) throws IOException {
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

    public String pouzitelnePredmety(String vstup,int i) throws IOException {
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
        } else if (vstup.equalsIgnoreCase("prasky")||vstup.equalsIgnoreCase("houby")) {
            if(predmet.getNazev().equalsIgnoreCase(vstup)){
                if(hra.getHrac().isPruzkum()&&hra.getHrac().getProzObjekt() instanceof Rozeznavatel rozeznavatel){
                    odpoved = rozeznavatel.rozpoznatLatku(vstup,hra.getHrac());
                    System.out.println("FAZE POSTAV: "+hra.getMomentalniMistnost().getPostava().getFaze());
                }
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
