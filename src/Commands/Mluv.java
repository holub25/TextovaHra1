package Commands;

import Postavy.Ben;
import Postavy.Postava;
import Predmety.Klice;
import zbytek.Hra;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Mluv implements Command{

    private Hra hra;
    private String[] rozdeleni;
    private HashSet<String>  otazky;

    public Mluv(Hra hra) {
        this.hra = hra;
        otazky = new HashSet<>();
    }

    @Override
    public String prikaz(String vstup) throws Exception {
        FileReader fileReader = new FileReader("Scenar");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        if(!hra.getMomentalniMistnost().getPostava().getJmeno().equalsIgnoreCase(vstup)){
            return "Postava není v mistnosti";
        }
        String line;
        int cisloOtazky = zvoleniOtazky();
        while ((line = bufferedReader.readLine())!=null){
            String[] rozdeleni = line.split(";",4);
            if(vstup.equalsIgnoreCase(rozdeleni[0]) /*&& faze()<=Integer.parseInt(rozdeleni[1])*/ && vstup.equalsIgnoreCase(hra.getMomentalniMistnost().getPostava().getJmeno()) && cisloOtazky==Integer.parseInt(line.split(";")[2])){
                rozdeleni[3] = rozdeleni[3].replace("\\n","\n");
                zjisteni(vstup,cisloOtazky);
                System.out.println("FAZE: "+faze());
                /*if(vstup.equalsIgnoreCase("Elenora")&&faze()==1){
                    zvyseniFaze();
                    hra.getHrac().setFazeHrace(2);
                }else if(vstup.equalsIgnoreCase("Jack")&&faze()==2&&cisloOtazky==22&&hra.getHrac().getFazeHrace()==2){
                    zvyseniFazeHrac();
                }*/
                return rozdeleni[3];
            }
        }
        bufferedReader.close();
        fileReader.close();
        return "Postava nebo otazka nenalezena";
    }
    //(faze()==Integer.parseInt(rozdeleni[1])||faze()==Integer.parseInt(rozdeleni[1])+1||faze()==Integer.parseInt(rozdeleni[1])-1)
    public int zvoleniOtazky() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileReader fileReader = new FileReader("Otazky");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int i = 1;
        while ((line = bufferedReader.readLine())!=null){
            if(Integer.parseInt(line.split(";")[1]) == hra.getHrac().getFazeHrace()){
                otazky.add(line.split(";")[3]);
            }
        }
        ArrayList<String> list = new ArrayList<>(otazky);
        for(int c = 0;c<otazky.size();c++){
            System.out.println(c+1+". "+list.get(c));
        }
        System.out.print("Zvolte otazku (cislo): \n>> ");
        int id = 0;
        try{
            int odpoved = sc.nextInt();
            FileReader fileReader1 = new FileReader("Otazky");
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            String line1;
            for(int v = 0;v<otazky.size();v++){
                if(odpoved == v+1){
                    while ((line1 = bufferedReader1.readLine())!=null){
                        if(list.get(v).equalsIgnoreCase(line1.split(";")[3])){
                            id = Integer.parseInt(line1.split(";")[2]);
                        }
                    }
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Zadavej pouze pismena");
        }
        bufferedReader.close();
        fileReader.close();
        return id;
    }
    public int faze(){
        return hra.getMomentalniMistnost().getPostava().getFaze();
    }
    public void zvyseniFaze(){
        for (int i = 0;i<hra.getSvet().getMistnosti().size();i++){
            if(hra.getSvet().getMistnosti().get(i).getPostava()!=null){
                hra.getSvet().getMistnosti().get(i).getPostava().zmenaFaze();
            }
        }
    }

    public void zjisteni(String jmeno,int cisloOtazky){
        if(jmeno.equalsIgnoreCase("Elenora")&&/*faze()==1*/hra.getHrac().getFazeHrace()==1){
            zvyseniFaze();
            hra.getHrac().setFazeHrace(2);
        }else if(jmeno.equalsIgnoreCase("Jack")/*&&faze()==2*/&&cisloOtazky==22&&hra.getHrac().getFazeHrace()==2){
            hra.getHrac().zvyseniFazeHrac();
            zvyseniFaze();
        }else if(jmeno.equalsIgnoreCase("Ben")/*&&faze()==4*/&&cisloOtazky==44&&hra.getHrac().getFazeHrace() == 4){
            if(hra.getMomentalniMistnost().getPostava() instanceof Ben ben){
                ben.predaniKlice();
            }
        }
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
