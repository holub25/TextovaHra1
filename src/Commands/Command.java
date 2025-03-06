package Commands;

public interface Command {
    String prikaz(Object vstup);
    boolean exit();
}
