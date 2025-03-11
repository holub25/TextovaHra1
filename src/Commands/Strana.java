package Commands;

public class Strana implements Command{
    @Override
    public String prikaz(Object vstup) {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public boolean povoleniPruz() {
        return false;
    }
}
