package Commands;

import Postavy.Ben;
import Postavy.Postava;
import Predmety.Klice;
import zbytek.Hra;

import java.io.*;
import java.util.*;

public class Mluv implements Command{

    private Hra hra;
    private String[] rozdeleni;
    private LinkedHashSet<String>  otazky;

    public Mluv(Hra hra) {
        this.hra = hra;
        otazky = new LinkedHashSet<>();
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
            String[] rozdeleni = line.split(";",5);
            if(vstup.equalsIgnoreCase(rozdeleni[0]) /*&& faze()<=Integer.parseInt(rozdeleni[1])*/ && vstup.equalsIgnoreCase(hra.getMomentalniMistnost().getPostava().getJmeno()) && cisloOtazky==Integer.parseInt(line.split(";")[2])){
                rozdeleni[4] = rozdeleni[4].replace("\\n","\n");
                zjisteni(vstup,cisloOtazky);
                System.out.println("FAZE: "+faze());
                return rozdeleni[4];
            }
        }
        bufferedReader.close();
        fileReader.close();
        return "Postava nebo otazka nenalezena";
    }
    //(faze()==Integer.parseInt(rozdeleni[1])||faze()==Integer.parseInt(rozdeleni[1])+1||faze()==Integer.parseInt(rozdeleni[1])-1)
    public int zvoleniOtazky() throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = nahraniOtazek();
        System.out.print("Zvolte otazku (cislo): \n>> ");
        int id = 0;
        try{
            int odpoved = sc.nextInt();
            FileReader fileReader1 = new FileReader("Otazky");
            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
            String line1;
            for(int v = 0;v<list.size();v++){
                if(odpoved == v+1){
                    while ((line1 = bufferedReader1.readLine())!=null){
                        if(Integer.parseInt(line1.split(";")[3])==0){
                            if(list.get(v).equalsIgnoreCase(line1.split(";")[4])){
                                id = Integer.parseInt(line1.split(";")[2]);
                                System.out.println("LLLLLLLLLLLLLLLLLLLLLLLL");
                            }
                        } else  {
                            if(hra.getMomentalniMistnost().getPostava().getFaze()>=Integer.parseInt(line1.split(";")[3])){
                                if(list.get(v).equalsIgnoreCase(line1.split(";")[4])){
                                    id = Integer.parseInt(line1.split(";")[2]);
                                    System.out.println("KKKKKKKKKKKKKK");
                                }
                            }
                        }
                    }
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Zadavej pouze pismena");
        }
        otazky.clear();
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

    public void zjisteni(String jmeno,int cisloOtazky) throws Exception {
        if(jmeno.equalsIgnoreCase("Elenora")&&hra.getHrac().getFazeHrace()==1){
            zvyseniFaze();
            hra.getHrac().setFazeHrace(2);
        }else if(jmeno.equalsIgnoreCase("Jack")&&cisloOtazky==22&&hra.getHrac().getFazeHrace()==2){
            hra.getHrac().zvyseniFazeHrac();
            zvyseniFaze();
        }else if(jmeno.equalsIgnoreCase("Ben")&&cisloOtazky==44&&hra.getHrac().getFazeHrace() == 4){
            if(hra.getMomentalniMistnost().getPostava() instanceof Ben ben){
                ben.predaniKlice();
            }
        }
        else if(cisloOtazky==77&&hra.getHrac().getFazeHrace()==7){
            /*else if(jmeno.equalsIgnoreCase("Jack")&&cisloOtazky==77&&hra.getHrac().getFazeHrace()==7){
            hra.zvednoutFazeKonPost("Elenora");
        } else if(jmeno.equalsIgnoreCase("Elenora")&&cisloOtazky==77&&hra.getHrac().getFazeHrace()==7){
            hra.zvednoutFazeKonPost("Alfred");
        } else if (jmeno) {

        }*/
            switch (jmeno.toLowerCase()){
                case "jack":
                    hra.zvednoutFazeKonPost("Elenora");
                    break;
                case "elenora":
                    hra.zvednoutFazeKonPost("Alfred");
                    break;
            }
        }
    }
    public ArrayList<String> nahraniOtazek() throws IOException {
        FileReader fileReader = new FileReader("Otazky");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!=null){
            if(Integer.parseInt(line.split(";")[1]) <= hra.getHrac().getFazeHrace()){
                //System.out.println("POCET");
                jednotliveOtazky(line);
            }
        }
        ArrayList<String> list = new ArrayList<>(otazky);
        for(int c = 0;c<otazky.size();c++){
            System.out.println(c+1+". "+list.get(c));
        }
        bufferedReader.close();
        fileReader.close();
        return list;
    }
    public void jednotliveOtazky(String line){
        if(line.split(";")[0].equalsIgnoreCase(hra.getMomentalniMistnost().getPostava().getJmeno())&&Integer.parseInt(line.split(";")[3])<=hra.getMomentalniMistnost().getPostava().getFaze()){
            otazky.add(line.split(";")[4]);
            System.out.println("TU TO JDE");
        }else if(line.split(";")[0].equalsIgnoreCase("All")&&hra.getHrac().getFazeHrace()>=Integer.parseInt(line.split(";")[1])){
            //System.out.println("FAZE HRACE OTAZ: "+hra.getHrac().getFazeHrace());
            otazky.add(line.split(";")[4]);
            System.out.println("TU TO JDE 222");
            //System.out.println("VELIKOST OTAZEK JE: "+otazky.size());
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
