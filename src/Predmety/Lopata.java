package Predmety;

import Mistnosti.Mistnost;
import Objekty.Dira;
import zbytek.Hra;

public class Lopata extends Predmet{
    private Hra hra;
    public Lopata(String nazev, Mistnost poloha, boolean sebrana) {
        super(nazev, poloha, sebrana);
    }

    public Hra getHra() {
        return hra;
    }

    public void setHra(Hra hra) {
        this.hra = hra;
    }

    /**
     * Metoda pro použití lopaty v konkrétní fázi.
     * @return Vrací potvrzení zda lopata byla použita nebo nebyla.
     */
    public String pouzitiLopata(){
        if (hra.getMomentalniMistnost().getPostava().getFaze()>=5) {
            if(hra.getMomentalniMistnost().getObjekt() instanceof Dira dira){
                if(!dira.isVykopana()){
                    dira.setVykopana(true);
                    return "Vykopal jste díru";
                }
            }
        }
        return "Nemá cenu kopat díru";
    }
}
