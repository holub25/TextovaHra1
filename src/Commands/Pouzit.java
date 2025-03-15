package Commands;

import Predmety.Klice;
import zbytek.Hra;

public class Pouzit implements Command {
    private Hra hra;

    public Pouzit(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(String vstup) {
        for(int i = 0;i<hra.getMomentalniMistnost().getPouzitelnePredmety().size();i++){
            if(hra.getMomentalniMistnost().getPouzitelnePredmety().get(i).equalsIgnoreCase(vstup)){
                for(int b = 0;b<hra.getHrac().getInventory().getPredmety().size();b++){
                    if(hra.getHrac().getInventory().getPredmety().get(b).getNazev().equalsIgnoreCase(vstup)){
                        return "Muzes";
                    }
                }
                return "Předmět nemáte u sebe";


            }

        }
        for(int i = 0;i<hra.getMomentalniMistnost().getObjekt().getPouzitelnePredmety().size();i++){
            if(hra.getMomentalniMistnost().getObjekt().getPouzitelnePredmety().get(i).equalsIgnoreCase(vstup)){
                for(int b = 0;b<hra.getHrac().getInventory().getPredmety().size();b++){
                    if(hra.getHrac().getInventory().getPredmety().get(b).getNazev().equalsIgnoreCase(vstup)){
                        return "Muzes";
                    }

                }
                return "Předmět nemáte u sebe";
            }
        }
        return "Předmět zde nemůžete použít";
    }

    public String pouzitelnePredmety(String vstup,int i){
        switch (vstup.toLowerCase()){
            case "klice":
                if(hra.getHrac().getInventory().getPredmety().get(i) instanceof Klice klice){

                }
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
        return false;
    }
}
