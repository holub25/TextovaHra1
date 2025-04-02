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

    /**
     * Metoda která ze souboru nahraje jednotlivé strany do knihy.
     * @param nazev je název knihy podle které se nahrávají strany.
     * @throws IOException kontroluje možnou chybu při načítání ze souboru.
     */
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
        bufferedReader.close();
        fileReader.close();
    }

    private int stranka = 0;

    /**
     * Tato metoda přepíná mezi jednotlivími stranami v knize podle vstupu.
     * @param vstup je buď + nebo -.
     * @param hrac je postava hráče.
     * @return Vrací obsah jednotlivé strany.
     */
    public String zobrazeniStrany(String vstup, Hrac hrac){
        if(vstup.equals("+")){
            stranka++;
        }else if(vstup.equals("-")){
            stranka--;
        }else {
            return "Muzete zadat pouze +/-";
        }
        if(stranka == 3&&hrac.getFazeHrace()==6&&hrac.getCtenaKniha().nazev.equalsIgnoreCase("kniha3")){
            hrac.zvyseniFazeHrac();
        }
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
