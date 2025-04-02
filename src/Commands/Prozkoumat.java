package Commands;

import Objekty.*;
import zbytek.Hra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Prozkoumat implements Command{
    private Hra hra;

    public Prozkoumat(Hra hra) {
        this.hra = hra;
    }

    /**
     * Umožní hráči przkoumat objekty v daných místnostech.
     * @param vstup objekt který chce hráč prozkoumat.
     * @return popi objektu.
     * @throws IOException kvůli možné chybě při načítání ze souboru.
     */

    @Override
    public String prikaz(String vstup) throws IOException {
        FileReader fileReader = new FileReader("PopisObjekty");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine())!=null){
            if(hra.getMomentalniMistnost().getObjekt() == null){
                return "V teto mistnosti není objekt";
            }else if(objektoveAktivity(vstup)&&hra.getMomentalniMistnost().getObjekt().getNazev().equalsIgnoreCase(vstup) && line.split(";")[0].equalsIgnoreCase(vstup)){
                hra.getHrac().setPruzkum(true);
                hra.getHrac().setProzObjekt(hra.getMomentalniMistnost().getObjekt());
                objektNalez(vstup);
                return line.split(";")[1]+"\n"+hra.getMomentalniMistnost().getObjekt().toString();
            }
        }
        return "Objekt nenalezen nebo nelze prozkoumat";
    }

    /**
     * U některých objektů je třeba splnit aktivitu k jejich przkoumání.
     * @param vstup název objektu.
     * @return vrací zda je možné objekt prozkoumat či ne.
     */
    public boolean objektoveAktivity(String vstup){
        switch (vstup.toLowerCase()){
            case "trezor":
                if(hra.getMomentalniMistnost().getObjekt() instanceof Trezor trezor){
                    return trezor.otevreniTrezoru();
                }
            case "rozeznavatel":
                return true;
            case "krb":
                if(hra.getMomentalniMistnost().getObjekt() instanceof Krb krb){
                    if(krb.pruzkum()){
                        hra.zvednoutFazeKonPost("Morgan",5);
                        return krb.pruzkum();
                    }
                    return krb.pruzkum();
                }
            case "dira":
                if(hra.getMomentalniMistnost().getObjekt() instanceof Dira dira){
                    if(dira.isVykopana()){
                        return true;
                    }
                    return false;
                }
            case "knihovna":
                return true;

        }
        return false;
    }

    /**
     * Metoda která spouští akce když hráč prozkoumává daný objekt v určitou fázi.
     * @param vstup název objektu.
     */
    public void objektNalez(String vstup){
        for(int i = 0;i<hra.getSvet().getMistnosti().size();i++){
            if(vstup.equalsIgnoreCase("Dira")){
                if(hra.getMomentalniMistnost().getPostava().getFaze()>=5){
                    hra.zvednoutFazeKonPost(hra.getMomentalniMistnost().getPostava().getJmeno(),6);
                }
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
