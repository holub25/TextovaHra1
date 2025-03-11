package zbytek;

import Commands.*;
import Mistnosti.Mistnost;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Hra {
    private boolean exit = false;
    private HashMap<String, Command> prikazy;
    private Scanner sc = new Scanner(System.in);
    private Mistnost momentalniMistnost;
    private Hrac hrac;

    public Hra(Mistnost momentalniMistnost) {
        this.exit = false;
        this.prikazy = new HashMap<>();
        this.momentalniMistnost = momentalniMistnost;
        System.out.println(momentalniMistnost.getNazev());
        hrac = new Hrac("",10,momentalniMistnost);
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
    }


    public void konzole() {
        try {
            System.out.print(">> ");
            String prikaz = sc.nextLine().toLowerCase();
            if(prikazy.containsKey(prikaz.split(" ")[0]) && (!hrac.isPruzkum() || prikazy.get(prikaz.split(" ")[0]).povoleniPruz())){
                if(prikaz.split(" ").length>1){
                    System.out.println(prikazy.get(prikaz.split(" ")[0]).prikaz(prikaz.split(" ")[1]));
                }else {
                    System.out.println(prikazy.get(prikaz.split(" ")[0]).prikaz(null));
                }
                exit = prikazy.get(prikaz.split(" ")[0]).exit();
            }else {
                System.out.println("Příkaz nenalezen, nebo nelze použít");
            }
        }catch (IOException e){
            System.out.println("chyba!!!");
        }

    }
    public void start(Svet svet){
        inicializace(svet);
        System.out.println("VÍTEJ");
        System.out.println(hrac.nastaveniJmena());
        try{
            do {
                konzole();
            }while (!exit);
        }catch (Exception e){
            //System.out.println(e.getMessage());
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
