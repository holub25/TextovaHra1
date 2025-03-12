package Commands;

import Postavy.Postava;
import zbytek.Hra;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Mluv implements Command{

    private Hra hra;

    public Mluv(Hra hra) {
        this.hra = hra;
    }

    @Override
    public String prikaz(String vstup) throws IOException {
        FileReader fileReader = new FileReader("Scenar");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int cisloOtazky = zvoleniOtazky();
        while ((line = bufferedReader.readLine())!=null){
            String[] rozdeleni = line.split(";",4);
            if(vstup.equalsIgnoreCase(rozdeleni[0]) && faze()==Integer.parseInt(rozdeleni[1]) && vstup.equalsIgnoreCase(hra.getMomentalniMistnost().getPostava().getJmeno()) && Integer.parseInt(rozdeleni[2])==cisloOtazky){
                return rozdeleni[3];
            }
        }
        bufferedReader.close();
        fileReader.close();
        return "Postava nebo otazka nenalezena";
    }
    public int zvoleniOtazky() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileReader fileReader = new FileReader("Otazky");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int i = 1;
        while ((line = bufferedReader.readLine())!=null){
            if(Integer.parseInt(line.split(";")[1]) == hra.getHrac().getFazeHrace()){
                System.out.println(i+". "+line.split(";")[2]);
            }
        }
        System.out.print("Zvolte otazku (cislo): \n>> ");
        int odpoved = sc.nextInt();
        return odpoved;
    }
    public int faze(){
        return hra.getMomentalniMistnost().getPostava().getFaze();
    }


    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public boolean povoleniPruz() {
        return false;
    }

    @Override
    public boolean cteni() {
        return false;
    }
}
