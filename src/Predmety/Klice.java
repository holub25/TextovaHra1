package Predmety;

import Mistnosti.Mistnost;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Klice extends Predmet {

    private HashMap<String,String> slova;

    public Klice(String nazev, Mistnost poloha, boolean sebrana) {
        super(nazev, poloha, sebrana);
    }

    public boolean hadankaKlic() throws IOException {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        boolean odpoved = false;
        FileReader fileReader = new FileReader("Hadanka1");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        while (!odpoved){
            int random = rd.nextInt(101)-1;
            String slovoPo = "";
            String slovoCz = "";
            while ((line = bufferedReader.readLine())!=null){
                if(Integer.parseInt(line.split(";")[0]) == random){
                    slovoPo = line.split(";")[1];
                    slovoCz = line.split(";")[2];
                }
            }
            System.out.println("Napište český překlad slova: "+slovoPo+"\n>>");
            String hracOdpoved = sc.nextLine();
            if(hracOdpoved.equalsIgnoreCase(slovoCz)){
                odpoved = true;
            } else if (hracOdpoved.equalsIgnoreCase("zpet")) {
                System.out.println("Nenašel jste správný klíč");
                return false;
            } else {
                System.out.println("Spatna odpoved");
            }
        }
        return true;
    }
    public void nahraniSlov(){

    }
}
