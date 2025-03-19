package zbytek;

import Commands.*;
import Mistnosti.Mistnost;
import Postavy.Ben;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Hra {
    private boolean exit = false;
    private HashMap<String, Command> prikazy;
    private Scanner sc = new Scanner(System.in);
    private Mistnost momentalniMistnost;
    private Hrac hrac;
    private Svet svet;

    public Hra(Mistnost momentalniMistnost,Svet svet) {
        this.exit = false;
        this.prikazy = new HashMap<>();
        this.momentalniMistnost = momentalniMistnost;
        this.svet = svet;
        System.out.println(momentalniMistnost.getNazev());
        hrac = new Hrac("",5,momentalniMistnost,1);
        nastaveniPostav();
    }

    public void inicializace(Svet svet){
        prikazy.put("jdi",new Jdi(this,svet));
        prikazy.put("konec",new Konec());
        prikazy.put("vzit",new Vzit(this,hrac));
        prikazy.put("inventory",new OtevritInv(this));
        prikazy.put("mluv",new Mluv(this));
        prikazy.put("pouzit",new Pouzit(this));
        prikazy.put("prozkoumat",new Prozkoumat(this));
        prikazy.put("zpet",new Zpet(this));
        prikazy.put("cti",new Cti(this));
        prikazy.put("strana",new Strana(this));
        prikazy.put("pouzit",new Pouzit(this));
    }

    public Svet getSvet() {
        return svet;
    }

    public void konzole() throws Exception {
        try {
            System.out.print(">> ");
            String prikaz = sc.nextLine().toLowerCase();
            if(prikazy.containsKey(prikaz.split(" ")[0]) && (!hrac.isPruzkum() || prikazy.get(prikaz.split(" ")[0]).povoleniPruz()) && (!hrac.isCte() || prikazy.get(prikaz.split(" ")[0]).cteni())){
                if(prikaz.split(" ").length>1){
                    if(prikaz.split(" ")[0].equalsIgnoreCase("strana")&&hrac.isCte()==false){
                        System.out.println("Nelze pouzit");
                    }else {
                        System.out.println(prikazy.get(prikaz.split(" ")[0]).prikaz(prikaz.split(" ")[1]));
                    }
                }else {
                    System.out.println(prikazy.get(prikaz.split(" ")[0]).prikaz(null));
                }
                exit = prikazy.get(prikaz.split(" ")[0]).exit();
            }else {
                System.out.println("Příkaz nenalezen, nebo nelze použít");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void start(Svet svet){
        inicializace(svet);
        System.out.println("VÍTEJ");
        //System.out.println(hrac.nastaveniJmena());
        try{
            do {
                konzole();
            }while (!exit);
        }catch (Exception e){
            //System.out.println(e.getMessage());
        }
    }
    public void nastaveniPostav(){
        for (int i = 0;i<svet.getMistnosti().size();i++){
            if(svet.getMistnosti().get(i).getPostava() instanceof Ben ben){
                ben.setHra(this);
            }
        }
    }
    public void zvednoutFazeKonPost(String jmeno){
        for(int i = 0;i<svet.getMistnosti().size();i++){
            if(svet.getMistnosti().get(i).getPostava()==null){
                System.out.println("KONTROL funguje");
            }
            else if(svet.getMistnosti().get(i).getPostava().getJmeno().equalsIgnoreCase(jmeno)){
                svet.getMistnosti().get(i).getPostava().zmenaFaze();
                System.out.println("Faze postavy nova: "+svet.getMistnosti().get(i).getPostava().getFaze()+svet.getMistnosti().get(i).getPostava().getJmeno());
            }
        }
    }

    public HashMap<String, Command> getPrikazy() {
        return prikazy;
    }

    public Mistnost getMomentalniMistnost() {
        return momentalniMistnost;
    }

    public Hrac getHrac() {
        return hrac;
    }

    public void setMomentalniMistnost(Mistnost momentalniMistnost) {
        this.momentalniMistnost = momentalniMistnost;
    }
}
