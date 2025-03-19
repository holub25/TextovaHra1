package Predmety;

import Mistnosti.Mistnost;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Klice extends Predmet {

    public Klice(String nazev, Mistnost poloha, boolean sebrana) {
        super(nazev, poloha, sebrana);
    }
    public boolean hadankaKlic() throws IOException {
        ArrayList<String> radky = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        boolean odpoved = false;
        FileReader fileReader = new FileReader("Hadanka1");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!=null){
            radky.add(line);
        }
        while (!odpoved){
            int random = rd.nextInt(101)-1;
            String slovoPo = "";
            String slovoCz = "";
            for(int i = 0;i<radky.size();i++){
                if(random==Integer.parseInt(radky.get(i).split(";")[0])){
                    slovoPo = radky.get(i).split(";")[1];
                    slovoCz = radky.get(i).split(";")[2];
                }
            }
            System.out.print("Napište český překlad slova: "+slovoPo+"\n>>");
            String hracOdpoved = sc.nextLine();
            if(hracOdpoved.equalsIgnoreCase(slovoCz)){
                odpoved = true;
                System.out.println("Spravná odpověď");
                return false;
            } else if (hracOdpoved.equalsIgnoreCase("zpet")) {
                System.out.println("Nenašel jste správný klíč");
                return true;
            } else {
                System.out.println("Spatna odpoved");
                //SMAZAT
                return false;
            }
        }
        return false;
    }

}
