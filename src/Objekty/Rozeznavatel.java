package Objekty;

import Mistnosti.Mistnost;
import Predmety.Predmet;
import zbytek.Hrac;
import zbytek.Svet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Rozeznavatel extends Objekt{
    Svet svet;
    public Rozeznavatel(String nazev, Mistnost polohaObjektu,Predmet predmet,Svet svet) {
        super(nazev, polohaObjektu,predmet);
        this.svet = svet;
    }

    /**
     * Metoda která hráči pomůže rozpoznat látku daného předmětu. Generuje také příklad.
     * @param latka název předmětu.
     * @param hrac je Postava hráče.
     * @return Vrátí co za látku je daný předmět
     * @throws IOException kontroluje chybu při načítání souboru.
     */

    public String rozpoznatLatku(String latka,Hrac hrac) throws IOException {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        FileReader fileReader = new FileReader("Latky");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int cislo1;
        int cislo2;
        String odpoved;
        boolean pravda = false;
        System.out.println("K rozeznání látky je třeba vypočítat příklad");
        while(!pravda){
            cislo1 = rd.nextInt(500)+1;
            cislo2 = rd.nextInt(500)+1;
            System.out.println("Příklad: "+cislo1+" + "+cislo2+"\n>> ");
            odpoved = sc.nextLine();
            if(odpoved.equalsIgnoreCase("zpet")){
                return "Ukončil jste rozeznávání";
            }
            else if(Integer.parseInt(odpoved) == cislo1 + cislo2){
                System.out.println("Spravna odpoved");
                String line;
                while ((line = bufferedReader.readLine())!=null){
                    if(line.split(";")[0].equalsIgnoreCase(latka)){
                        if(hrac.getFazeHrace()==5){
                            hrac.zvyseniFazeHrac();
                        }
                        return "LÁTKA JE: "+line.split(";")[0];
                    }
                }
            }
            System.out.println("Odpoved je spatna");
        }
        return "";
    }
}
