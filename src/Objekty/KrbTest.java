package Objekty;

import Mistnosti.Hala;
import Mistnosti.Mistnost;
import Mistnosti.Sklep;
import Postavy.Morgan;
import Postavy.Postava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zbytek.Hra;
import zbytek.Svet;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KrbTest {
    private Krb krb;
    private Hra hra;
    private Mistnost hala;
    private Postava morgan;
    private Svet svet;
    private ArrayList<Mistnost> mistnosti;

    @BeforeEach
    void setUp() throws IOException {
        mistnosti = new ArrayList<>();
        svet = new Svet();
        hala = new Hala("hala",null);
        hra = new Hra(hala,svet);
        krb = new Krb("krb",hala,null);
        krb.setHra(hra);
        morgan = new Morgan("morgan",hala,3);
        hala.setPostava(morgan);
        mistnosti.add(hala);
        svet.setMistnosti(mistnosti);
    }

    /**
     * Metoda která otestuje zda důkladnější průzkum krbu funguje.
     */
    @Test
    void pruzkumUspech() {
        morgan.setFaze(5);
        assertTrue(krb.pruzkum());
    }
    /**
     * Metoda která otestuje zda důkladnější průzkum krbu nefunguje.
     */
    @Test
    void pruzkumNeuspech() {
        assertFalse(krb.pruzkum());
    }
}