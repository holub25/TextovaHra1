import Mistnosti.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Svet {


    private ArrayList<Mistnost> mistnosti;

    public Svet() {
        this.mistnosti = new ArrayList<>();
        nacteniMapy();
    }
    public ArrayList<String> rozdeleniSousedu(String radek,String nazev){
        String[] sousedi = radek.split(";");
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0;i<sousedi.length;i++){
            if(!sousedi[i].equalsIgnoreCase(nazev)){
                list.add(sousedi[i].toLowerCase());
            }
        }
        return list;
    }

    public void nacteniMapy(){
        try {
            FileReader fileReader = new FileReader("Mapa");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null){
                String nazev = line.split(";")[0].toLowerCase();
                switch (nazev){
                    case "hala":
                        mistnosti.add(new Hala(nazev,rozdeleniSousedu(line,nazev)));
                        break;
                    case "kuchyne":
                        mistnosti.add(new Kuchyn(nazev,rozdeleniSousedu(line,nazev)));
                        break;
                    case "kancelar":
                        mistnosti.add(new Kancelar(nazev,rozdeleniSousedu(line,nazev)));
                        break;
                    case "loznice 1":
                        mistnosti.add(new Loznice1(nazev,rozdeleniSousedu(line,nazev)));
                        break;
                    case "loznice 2":
                        mistnosti.add(new Loznice2(nazev,rozdeleniSousedu(line,nazev)));
                        break;
                    case "sklep":
                        mistnosti.add(new Sklep(nazev,rozdeleniSousedu(line,nazev)));
                        break;
                    case "zahrada":
                        mistnosti.add(new Zahrada(nazev,rozdeleniSousedu(line,nazev)));
                        break;
                    case "knihovna":
                        mistnosti.add(new Knihovna(nazev,rozdeleniSousedu(line,nazev)));
                        break;

                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList<Mistnost> getMistnosti() {
        return mistnosti;
    }
}
