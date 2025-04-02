package Commands;

import zbytek.Hra;

import java.io.BufferedReader;
import java.io.FileReader;

public class Pomoc implements Command{



    public Pomoc() {
    }

    @Override
    public String prikaz(String vstup) throws Exception {
        FileReader fileReader = new FileReader("PomocText");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String text = "";
        while ((line = bufferedReader.readLine())!=null){
            text = text + "\n"+line;
        }
        return text;
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
