package Commands;

public class Konec implements Command {
    @Override
    public String prikaz(String vstup) {
        return "Konec hry.";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
