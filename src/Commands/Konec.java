package Commands;

public class Konec implements Command {
    /**
     * Metoda pro potvrzení o ukončení hry.
     * @param vstup v této metodě není potřeba.
     * @return Vypíše pouze že hra skončila.
     */
    @Override
    public String prikaz(String vstup) {
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
