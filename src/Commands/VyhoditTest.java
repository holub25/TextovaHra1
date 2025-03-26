package Commands;

import Mistnosti.Hala;
import Mistnosti.Mistnost;
import Mistnosti.Sklep;
import Predmety.Lopata;
import Predmety.Predmet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zbytek.Hra;
import zbytek.Svet;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class VyhoditTest {
    private Hra hra;
    private Vyhodit vyhodit;
    private Mistnost hala;
    private Mistnost sklep;
    private Predmet lopata;

    @BeforeEach
    void setUp() throws IOException {
        hala = new Hala("hala",null);
        sklep = new Sklep("sklep",null);
        hra = new Hra(hala,new Svet());
        vyhodit = new Vyhodit(hra);
        lopata = new Lopata("lopata",sklep,false);
        hra.getHrac().getInventory().getPredmety().add(lopata);
    }

    /**
     * Otestuje zda jde vyhodit předmět.
     * @throws Exception
     */

    @Test
    void prikazVyhoditPredmet() throws Exception {
        String odpoved = vyhodit.prikaz("Lopata");
        assertEquals("Odebran Lopata", odpoved);
        assertFalse(hra.getHrac().getInventory().getPredmety().contains(lopata));
        assertTrue(hala.getPredmetyVMistnosti().contains(lopata));
    }

    /**
     * Otestuje zda nejde vyhodit předmět.
     * @throws Exception
     */
    @Test
    void prikazVyhoditPredmetSpatny() throws Exception {
        String odpoved = vyhodit.prikaz("Klice");
        assertEquals("Predmet nenalezen",odpoved);
    }
}