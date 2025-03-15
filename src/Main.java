import zbytek.Hra;
import zbytek.Svet;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            Svet svet = new Svet();
            Hra hra = new Hra(svet.getMistnosti().get(0),svet);
            hra.start(svet);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}