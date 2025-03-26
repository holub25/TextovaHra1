package Predmety;

import Mistnosti.Mistnost;
import Mistnosti.Sklep;
import Mistnosti.Zahrada;
import Objekty.Dira;
import Postavy.Alfred;
import Postavy.Postava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zbytek.Hra;
import zbytek.Svet;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LopataTest {
    private Lopata lopata;
    private Hra hra;
    private Mistnost zahrada;
    private Mistnost sklep;
    private Dira dira;
    private Postava postava;

    @BeforeEach
    void setUp() throws IOException {
        sklep = new Sklep("sklep",null);
        zahrada = new Zahrada("Zahrada",null);
        dira = new Dira("dira",zahrada,null);
        postava = new Alfred("Alfred",zahrada,5);
        zahrada.setObjekt(dira);
        zahrada.setPostava(postava);
        hra = new Hra(zahrada, new Svet());
        lopata = new Lopata("Lopata", sklep, true);
        lopata.setHra(hra);

    }

    @Test
    void pouzitiLopata() {
        String result = lopata.pouzitiLopata();
        assertEquals("Vykopal jste díru", result);
        assertTrue(dira.isVykopana());
    }

    @Test
    void pouzitiLopataSpatneFaze() {
        postava.setFaze(3);
        String result = lopata.pouzitiLopata();
        assertEquals("Nemá cenu kopat díru", result);
        assertFalse(dira.isVykopana());
    }
}