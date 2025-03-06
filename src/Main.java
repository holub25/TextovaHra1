import zbytek.Hra;
import zbytek.Svet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Svet svet = new Svet();
        Hra hra = new Hra(svet.getMistnosti().get(0));
        hra.start(svet);

    }
}