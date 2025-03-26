package Predmety;

import Commands.Strana;
import Mistnosti.Mistnost;
import zbytek.Hrac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Kniha extends Predmet{

    protected HashMap<Integer, String> strany;
    protected String nazev;
    public Kniha(String nazev, Mistnost poloha, boolean sebrana) {
        super(nazev, poloha, sebrana);
        this.strany = new HashMap<>();
        this.nazev = nazev;
    }
    public void nahraniStran(String nazev) throws IOException {
        FileReader fileReader = new FileReader("Knihy");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String radek;
        while ((line = bufferedReader.readLine())!=null){
            if(line.split(";")[0].equalsIgnoreCase(nazev)){
                radek = line.split(";")[2].replace("\\n","\n");
                strany.put(Integer.parseInt(line.split(";")[1]),radek);
            }
        }
    }

    private int stranka = 0;
    public String zobrazeniStrany(String vstup, Hrac hrac){
        if(vstup.equals("+")){
            stranka++;
        }else if(vstup.equals("-")){
            stranka--;
        }else {
            return "Muzete zadat pouze +/-";
        }
        if(stranka == 2&&hrac.getFazeHrace()==6&&hrac.getCtenaKniha().nazev.equalsIgnoreCase("kniha2")){
            hrac.zvyseniFazeHrac();
        }
        /*if(strany.get(stranka)==null){
            System.out.println(strany.get(stranka));
            return "Stranka nenalezena";
        }*/
         if(stranka == 0){
            stranka = 1;
            return "Jste na první straně";
        }else if(stranka==strany.size()+1&&stranka!=1){
            stranka = strany.size();
            return "Jste na poslední straně";
        }else {
            return strany.get(stranka);
        }

    }

    public void setStranka(int stranka) {
        this.stranka = stranka;
    }

    @Override
    public String getNazev() {
        return nazev;
    }


}
