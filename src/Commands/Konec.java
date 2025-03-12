package Commands;

public class Konec implements Command {
    @Override
    public String prikaz(Object vstup) {
        return "Konec hry.";
    }

    @Override
    public boolean exit() {
        return true;
    }

    @Override
    public boolean povoleniPruz() {
        return true;
    }

    @Override
    public boolean cteni() {
        return true;
    }
}
