package zbytek;

import Commands.*;
import Mistnosti.Mistnost;
import Objekty.Krb;
import Postavy.Ben;
import Predmety.Dlato;
import Predmety.Lopata;

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
        nastaveniPredmetu();
        nastaveniObjektu();
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
        prikazy.put("vyhodit",new Vyhodit(this));
    }

    public Svet getSvet() {
        return svet;
    }

    public String konzole() throws Exception {
        try {
            System.out.print(">> ");
            String prikaz = sc.nextLine().toLowerCase();
            System.out.println(soucetFazi());
            if(soucetFazi()==33){
                obvineni();
                return "";
            }
            else if(prikazy.containsKey(prikaz.split(" ")[0]) && (!hrac.isPruzkum() || prikazy.get(prikaz.split(" ")[0]).povoleniPruz()) && (!hrac.isCte() || prikazy.get(prikaz.split(" ")[0]).cteni())){
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
        return "";

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
    public void nastaveniObjektu(){
        for(int i = 0;i<svet.getMistnosti().size();i++){
            if(svet.getMistnosti().get(i).getObjekt() instanceof Krb krb){
                krb.setHra(this);
            }
        }
    }
    public void nastaveniPredmetu(){
        for(int i = 0;i<svet.getMistnosti().size();i++){
            for(int b = 0;b<svet.getMistnosti().get(i).getPredmetyVMistnosti().size();b++){
                if(svet.getMistnosti().get(i).getPredmetyVMistnosti().get(b) instanceof Dlato dlato){
                    dlato.setHra(this);
                } else if (svet.getMistnosti().get(i).getPredmetyVMistnosti().get(b) instanceof Lopata lopata) {
                    lopata.setHra(this);
                }
            }
        }
    }
    public void zvednoutFazeKonPost(String jmeno,int faze){
        for(int i = 0;i<svet.getMistnosti().size();i++){
            if(svet.getMistnosti().get(i).getPostava()==null){
                System.out.println("KONTROL funguje");
            }
            else if(svet.getMistnosti().get(i).getPostava().getJmeno().equalsIgnoreCase(jmeno)){
                if(faze>svet.getMistnosti().get(i).getPostava().getFaze()){
                    svet.getMistnosti().get(i).getPostava().setFaze(faze);
                    System.out.println(svet.getMistnosti().get(i).getPostava().getJmeno()+svet.getMistnosti().get(i).getPostava().getFaze());
                }
                //System.out.println("Faze postavy nova: "+svet.getMistnosti().get(i).getPostava().getFaze()+svet.getMistnosti().get(i).getPostava().getJmeno());
            }
        }
    }
    public int fazePostavy(String jmeno){
        for(int i = 0;i<svet.getMistnosti().size();i++){
            if(svet.getMistnosti().get(i).getPostava()==null){

            }
            else if(svet.getMistnosti().get(i).getPostava().getJmeno().equalsIgnoreCase(jmeno)){
                return svet.getMistnosti().get(i).getPostava().getFaze();
            }
        }
        return 0;
    }
    public int soucetFazi(){
        int soucet = 0;
        for(int i = 0;i<svet.getMistnosti().size();i++){
            if(svet.getMistnosti().get(i).getPostava()==null){

            } else {
                soucet = soucet+svet.getMistnosti().get(i).getPostava().getFaze();
            }
        }
        return soucet;
    }
    public String obvineni(){
        Scanner sc = new Scanner(System.in);
        String odpoved = sc.nextLine();
        exit = true;
        if(odpoved.equalsIgnoreCase("Anna")){
            return "Gratuluji vyhrál jste";
        }else {
            return "Bohuzel jste obvinil špatného";
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
