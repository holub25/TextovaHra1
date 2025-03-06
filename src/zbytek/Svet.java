package zbytek;

import Mistnosti.*;
import Objekty.*;
import Postavy.*;
import Predmety.Dlato;
import Predmety.LahvickaFPrasky;
import Predmety.LahvickaHouby;
import Predmety.Lopata;

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
    public void nahraniObsahu(){
        for(int i = 0;i<mistnosti.size();i++){
            switch (mistnosti.get(i).getNazev()){
                case "hala":
                    mistnosti.get(i).pridatPredmet(new LahvickaFPrasky("Prasky",mistnosti.get(i),false));
                    mistnosti.get(i).pridatPostavu(new Morgan("Morgan",mistnosti.get(i),mistnosti.get(i).getPostava().nahraniPopisu(),1));
                    mistnosti.get(i).pridatObjekt(new Krb("Krb",mistnosti.get(i)));
                case "kuchyne":
                    mistnosti.get(i).pridatPredmet(new LahvickaHouby("Houby",mistnosti.get(i),false));
                    mistnosti.get(i).pridatPostavu(new Anna("Anna",mistnosti.get(i),mistnosti.get(i).getPostava().nahraniPopisu(),1));
                case "kancelar":
                    mistnosti.get(i).pridatPostavu(new Stuart("Stuart",mistnosti.get(i),mistnosti.get(i).getPostava().nahraniPopisu(),1));
                    mistnosti.get(i).pridatObjekt(new Rozeznavatel("Rozeznavatel",mistnosti.get(i)));
                case "loznice 1":
                    mistnosti.get(i).pridatPostavu(new Elenora("Elenora",mistnosti.get(i),mistnosti.get(i).getPostava().nahraniPopisu(),1));
                case "loznice 2":
                    mistnosti.get(i).pridatPostavu(new Jack("Jack",mistnosti.get(i),mistnosti.get(i).getPostava().nahraniPopisu(),1));
                case "sklep":
                    mistnosti.get(i).pridatPredmet(new Dlato("Dlato",mistnosti.get(i),false));
                    mistnosti.get(i).pridatPredmet(new Lopata("Lopata",mistnosti.get(i),false));
                    mistnosti.get(i).pridatObjekt(new Trezor("Trezor",mistnosti.get(i)));
                case "zahrada":
                    mistnosti.get(i).pridatPostavu(new Alfred("Alfred",mistnosti.get(i),mistnosti.get(i).getPostava().nahraniPopisu(),1));
                    mistnosti.get(i).pridatObjekt(new Dira("Dira",mistnosti.get(i)));
                case "knihovna":
                    mistnosti.get(i).pridatPostavu(new Ben("Ben",mistnosti.get(i),mistnosti.get(i).getPostava().nahraniPopisu(),1));
                    mistnosti.get(i).pridatObjekt(new KnihovnaObj("Knihovna",mistnosti.get(i)));
            }
        }
    }
    public ArrayList<Mistnost> getMistnosti() {
        return mistnosti;
    }
}
