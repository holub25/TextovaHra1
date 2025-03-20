package Objekty;

import Mistnosti.Mistnost;
import Predmety.Kniha;
import Predmety.Predmet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Trezor extends Objekt{

    private int kod;
    private boolean otevren;
    public Trezor(String nazev, Mistnost polohaObjektu,Predmet predmet,int kod,boolean otevren) throws IOException {
        super(nazev, polohaObjektu,predmet);
        this.kod = kod;
        this.otevren = otevren;
        nahraniDenik();
    }

    public boolean otevreniTrezoru(){
        boolean reseni = false;
        Scanner sc = new Scanner(System.in);
        if(otevren == true){
            return true;
        }else {
            while (!reseni){
                System.out.print("Zadejte 4místný kód k trezoru:"+"\n>>");
                String odpoved = sc.nextLine();
                if(odpoved.equalsIgnoreCase("Zpet")){
                    System.out.println("Nepodařilo se vám trezor otevřít");
                    return false;
                }
                int ciselnaOdpoved = Integer.parseInt(odpoved);
                if (ciselnaOdpoved == kod) {
                    //reseni = true;
                    otevren = true;
                    System.out.println("Zadal jste správný kód");
                    return true;
                } else if (odpoved.length() != 4) {
                    System.out.println("Můžete zadat pouze 4místny kód");
                }else {
                    System.out.println("Špatný kód");
                }
            }
            return false;
        }
    }
    public void nahraniDenik() throws IOException {
        for(int i = 0;i<predmetyVObjektu.size();i++){
            if(predmetyVObjektu.get(i) instanceof Kniha kniha){
                kniha.nahraniStran(predmetyVObjektu.get(i).getNazev());
            }
        }
    }
}
