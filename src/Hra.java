import Mistnosti.Mistnost;

import java.util.HashMap;
import java.util.Scanner;

public class Hra {
    private boolean exit = false;
    private HashMap<String,Command> prikazy;
    private Scanner sc = new Scanner(System.in);
    private Mistnost momentalniMistnost;

    public Hra(Mistnost momentalniMistnost) {
        this.exit = false;
        this.prikazy = new HashMap<>();
        this.momentalniMistnost = momentalniMistnost;
    }

    public void inicializace(Svet svet){
        prikazy.put("jdi",new Jdi(this,svet));
        prikazy.put("konec",new Konec());
    }

    public void konzole(){
        System.out.print(">> ");
        String prikaz = sc.nextLine().toLowerCase();
        if(prikazy.containsKey(prikaz.split(" ")[0])){
            if(prikaz.split(" ").length>1){
                System.out.println(prikazy.get(prikaz.split(" ")[0]).prikaz(prikaz.split(" ")[1]));
            }else {
                System.out.println(prikazy.get(prikaz.split(" ")[0]).prikaz(null));
            }
            exit = prikazy.get(prikaz.split(" ")[0]).exit();
        }else {
            System.out.println("Příkaz nenalezen");
        }
    }
    public void start(Svet svet){
        inicializace(svet);
        System.out.println("VÍTEJ");
        try{
            do {
                konzole();
            }while (!exit);
        }catch (Exception e){
            //System.out.println(e.getMessage());
        }

    }

    public Mistnost getMomentalniMistnost() {
        return momentalniMistnost;
    }

    public void setMomentalniMistnost(Mistnost momentalniMistnost) {
        this.momentalniMistnost = momentalniMistnost;
    }
}
