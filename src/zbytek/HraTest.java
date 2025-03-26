package zbytek;

import Mistnosti.Hala;
import Mistnosti.Kuchyn;
import Mistnosti.Mistnost;
import Postavy.Anna;
import Postavy.Morgan;
import Postavy.Postava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HraTest {

    private Svet svet;
    private Hra hra;


    @BeforeEach
    void setUp() throws IOException {
        svet = new Svet();
        hra = new Hra(null,svet);

        ArrayList<Mistnost> mistnosti = new ArrayList<>();
        Mistnost hala = new Hala("hala",null);
        Mistnost kuchyne = new Kuchyn("kuchyne",null);
        Postava morgan = new Morgan("morgan",hala,4);
        Postava anna = new Anna("anna",kuchyne,5);
        hala.setPostava(morgan);
        kuchyne.setPostava(anna);
        mistnosti.add(hala);
        mistnosti.add(kuchyne);
        svet.setMistnosti(mistnosti);
    }

    @Test
    void testSoucetFaziSpatny() {
        int soucet = hra.soucetFazi();
        assertNotEquals(8,soucet);
    }

    @Test
    void testSoucetFaziSpravny() {
        int soucet = hra.soucetFazi();
        assertEquals(9,soucet);
    }
}