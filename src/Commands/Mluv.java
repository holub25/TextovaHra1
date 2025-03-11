package Commands;

import Postavy.Postava;
import zbytek.Hra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Mluv implements Command{

    private Hra hra;

    public Mluv(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(Object vstup) throws IOException {
        FileReader fileReader = new FileReader("Scenar");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String jmeno = (String) vstup;
        while ((line = bufferedReader.readLine())!=null){
            String[] rozdeleni = line.split(";",3);
            if(jmeno.equalsIgnoreCase(rozdeleni[0]) && faze()==Integer.parseInt(rozdeleni[1]) && jmeno.equalsIgnoreCase(hra.getMomentalniMistnost().getPostava().getJmeno())){
                return rozdeleni[2];
            }
        }
        bufferedReader.close();
        fileReader.close();
        return "Postava nenalezena";
    }
    public int faze(){
        return hra.getMomentalniMistnost().getPostava().getFaze();
    }


    @Override
    public boolean exit() {
        return false;
    }
}
