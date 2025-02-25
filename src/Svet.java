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
    }

    public void nacteniMapy(){
        try {
            FileReader fileReader = new FileReader("Mapa");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null){
                String nazev = line.split(";")[0];
                switch (nazev.toLowerCase()){
                    case "hala":
                        mistnosti.add(new Hala(nazev));
                    case "kuchyne":
                        mistnosti.add(new Kuchyn(nazev));
                    case "kancelar":
                        mistnosti.add(new Kancelar(nazev));
                    case "loznice 1":
                        mistnosti.add(new Loznice1(nazev));
                    case "loznice 2":
                        mistnosti.add(new Loznice2(nazev));
                    case "sklep":
                        mistnosti.add(new Sklep(nazev));
                    case "zahrada":
                        mistnosti.add(new Zahrada(nazev));
                    case "knihovna":
                        mistnosti.add(new Knihovna(nazev));
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

    public Mistnost vytvoreniMistnosti(String nazev){
        switch (nazev.toLowerCase()){
            case "hala":
                return new Hala("Hala");
            case "kuchyne":
                return new Kuchyn("Kuchyně");
            case "kancelar":
                return new Kancelar("Kancelář");
            case "loznice 1":
                return new Loznice1("Ložnice 1");
            case "loznice 2":
                return new Loznice2("Ložnice 2");
            case "sklep":
                return new Sklep("Sklep");
            case "zahrada":
                return new Zahrada("Zahrada");
            case "knihovna":
                return new Knihovna("Knihovna");
            default:
                System.out.println("Chybna mistnost");
        }
        return null;
    }
}
