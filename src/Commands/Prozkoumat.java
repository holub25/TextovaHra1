package Commands;

import Objekty.Objekt;
import zbytek.Hra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prozkoumat implements Command{
    private Hra hra;

    public Prozkoumat(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(String vstup) throws IOException {
        FileReader fileReader = new FileReader("PopisObjekty");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!=null){
            if(hra.getMomentalniMistnost().getObjekt() == null){
                return "V teto mistnosti není objekt";
            }
            else if(hra.getMomentalniMistnost().getObjekt().getNazev().equalsIgnoreCase(vstup) && line.split(";")[0].equalsIgnoreCase(vstup)){
                hra.getHrac().setPruzkum(true);
                hra.getHrac().setProzObjekt(hra.getMomentalniMistnost().getObjekt());
                return line.split(";")[1];
            }
        }
        return "Objekt nenalezen";
    }


    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public boolean povoleniPruz() {
        return false;
    }

    @Override
    public boolean cteni() {
        return false;
    }
}
