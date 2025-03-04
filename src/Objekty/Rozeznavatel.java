package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;

import java.util.ArrayList;

public class Rozeznavatel extends Objekt{
    public Rozeznavatel(ArrayList<Predmet> predmetyVObjektu, Mistnost polohaObjektu) {
        super(predmetyVObjektu, polohaObjektu);
    }

    public String rozeznatLatku(){
        return null;
    }
}
