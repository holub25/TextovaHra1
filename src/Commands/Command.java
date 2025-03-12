package Commands;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
    String prikaz(String vstup) throws IOException;
    boolean exit();
    boolean povoleniPruz();
    boolean cteni();
}
