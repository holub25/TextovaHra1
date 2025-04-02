package zbytek;

import Mistnosti.*;
import Objekty.*;
import Postavy.*;
import Predmety.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Svet {

    private ArrayList<Mistnost> mistnosti;
    private String[] radek;

    public Svet() throws IOException {
        this.mistnosti = new ArrayList<>();
        nacteniMapy();
        nahraniObsahu();
        //nahraniMistnosti();
        //nahraniObjektu();
    }

    /**
     * Každé místnosti přidá sousedy.
     * @param radek je řádek ze souboru odkud se načítaj sousedi.
     * @param nazev je název místnosti ke které se sousedi přidávají.
     * @return vrátí list sousedů.
     */
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

    /**
     * Načte z mapy všechny místnosti a přidá je do arrayListu.
     */

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
                    case "loznice1":
                        mistnosti.add(new Loznice1(nazev,rozdeleniSousedu(line,nazev)));
                        break;
                    case "loznice2":
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

    /**
     * Mteoda která všem místnostem doplní ještě jejich obsah.
     * @throws IOException
     */
    public void nahraniObsahu() throws IOException {
        for(int i = 0;i<mistnosti.size();i++){
            switch (mistnosti.get(i).getNazev().toLowerCase()){
                case "hala":
                    mistnosti.get(i).pridatPredmet(new LahvickaFPrasky("Prasky",mistnosti.get(i),false));
                    mistnosti.get(i).pridatPostavu(new Morgan("Morgan",mistnosti.get(i),1));
                    mistnosti.get(i).pridatObjekt(new Krb("Krb",mistnosti.get(i),null));
                    mistnosti.get(i).pridatPouzitelnePred("Klice");
                    break;
                case "kuchyne":
                    mistnosti.get(i).pridatPredmet(new LahvickaHouby("Houby",mistnosti.get(i),false));
                    mistnosti.get(i).pridatPostavu(new Anna("Anna",mistnosti.get(i),1));
                    break;
                case "kancelar":
                    mistnosti.get(i).pridatPostavu(new Stuart("Stuart",mistnosti.get(i),1));
                    mistnosti.get(i).pridatObjekt(new Rozeznavatel("Rozeznavatel",mistnosti.get(i),null,this));
                    mistnosti.get(i).getObjekt().pridatPozitelnePred("Houby");
                    mistnosti.get(i).getObjekt().pridatPozitelnePred("Prasky");
                    mistnosti.get(i).getObjekt().pridatPozitelnePred("Omitka");
                    break;
                case "loznice1":
                    mistnosti.get(i).pridatPostavu(new Elenora("Elenora",mistnosti.get(i),1));
                    mistnosti.get(i).pridatPouzitelnePred("Dlato");
                    break;
                case "loznice2":
                    mistnosti.get(i).pridatPostavu(new Jack("Jack",mistnosti.get(i),1));
                    break;
                case "sklep":
                    mistnosti.get(i).pridatPredmet(new Dlato("Dlato",mistnosti.get(i),false));
                    mistnosti.get(i).pridatPredmet(new Lopata("Lopata",mistnosti.get(i),false));
                    mistnosti.get(i).pridatObjekt(new Trezor("Trezor",mistnosti.get(i),new Kniha("Denik",mistnosti.get(i),false),4444,false));
                    //mistnosti.get(i).getObjekt().pridaniPredmetu(new Denik("Denik",mistnosti.get(i),false));
                    break;
                case "zahrada":
                    mistnosti.get(i).pridatPostavu(new Alfred("Alfred",mistnosti.get(i),1));
                    mistnosti.get(i).pridatObjekt(new Dira("Dira",mistnosti.get(i),null));
                    mistnosti.get(i).pridatPouzitelnePred("Lopata");
                    //mistnosti.get(i).pridatPredmet(new Klice("Klice",mistnosti.get(i),false));
                    break;
                case "knihovna":
                    mistnosti.get(i).pridatPostavu(new Ben("Ben",mistnosti.get(i),1));
                    mistnosti.get(i).pridatObjekt(new KnihovnaObj("Knihovna",mistnosti.get(i),null));
                    Objekt obj = mistnosti.get(i).getObjekt();
                    if (obj instanceof KnihovnaObj knihovna) {
                        knihovna.pridaniKnihy(new Kniha("Kniha1", mistnosti.get(i), false));
                        knihovna.pridaniKnihy(new Kniha("Kniha2", mistnosti.get(i), false));
                        knihovna.pridaniKnihy(new Kniha("Kniha3", mistnosti.get(i), false));
                        knihovna.pridaniKnihy(new Kniha("Kniha4", mistnosti.get(i), false));
                        knihovna.pridaniKnihy(new Kniha("Kniha5", mistnosti.get(i), false));
                    }
                    break;
            }

        }
    }

    /**
     * Nahraje ze souboru informace o místnostech.
     * @throws IOException aby ochránila načítání ze souboru.
     */
    /*public void nahraniMistnosti() throws IOException {
        FileReader fileReader = new FileReader("ObsahMistnosti");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!=null){
            String[] radek = line.split(";");
            ArrayList<String> list = new ArrayList<>(prevod(radek));
            for(int i = 0;i<mistnosti.size();i++){
                Ben ben = new Ben("j",null,0);
                Krb krb = new Krb("j",null,null);
                //Predmet pr = null;
                if(mistnosti.get(i).getNazev().equalsIgnoreCase(radek[0])){
                    mistnosti.get(i).pridatPostavu(ben.zvoleniPostavy(radek[1],mistnosti.get(i)));
                    mistnosti.get(i).pridatObjekt(krb.zvoleniObjektu(radek[2],mistnosti.get(i),this));
                    String[] pouzPred = list.get(3).split("_");
                    String[] predmety = list.get(4).split("-");
                    mistnosti.get(i).pridaniVicePredmetu(predmety,mistnosti.get(i));
                    mistnosti.get(i).pridatPouzitelnePred(pouzPred);
                }
            }
        }
        bufferedReader.close();
        fileReader.close();
    }



    public void nahraniObjektu() throws IOException {
        FileReader fileReader = new FileReader("ObsahObjekty");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!=null){
            String[] radek = line.split(";");
            ArrayList<String> list = new ArrayList<>(prevod(radek));
            for(int i = 0;i<mistnosti.size();i++){
                String[] predmety = list.get(1).split("-");
                String[] pouzitelne = list.get(2).split("_");
                System.out.println("TREZOOOOOOR: "+predmety[0]);
                if(mistnosti.get(i).getObjekt()==null){

                }
                else if(mistnosti.get(i).getObjekt() instanceof KnihovnaObj knihovnaObj){
                    for(int b = 0;b<predmety.length;b++){
                        knihovnaObj.pridaniKnihy(predmety,mistnosti.get(i));
                    }
                    mistnosti.get(i).getObjekt().pridatPozitelnePred(pouzitelne);
                }
                else if(mistnosti.get(i).getObjekt().getNazev().equalsIgnoreCase(radek[0])){
                    System.out.println("OBJEKT: "+predmety[0]);
                    mistnosti.get(i).getObjekt().pridatVicePredmetu(predmety,mistnosti.get(i));
                    mistnosti.get(i).getObjekt().pridatPozitelnePred(pouzitelne);
                }

            }

        }

    }
    public ArrayList<String> prevod(String[] pole){
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0;i<pole.length;i++){
            list.add(pole[i]);
        }
        return list;
    }*/

    public void setMistnosti(ArrayList<Mistnost> mistnosti) {
        this.mistnosti = mistnosti;
    }

    public ArrayList<Mistnost> getMistnosti() {
        return mistnosti;
    }
}
