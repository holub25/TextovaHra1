package Predmety;

import Mistnosti.Knihovna;
import Mistnosti.Mistnost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import zbytek.Hra;
import zbytek.Hrac;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class KnihaTest {
    private Mistnost mistnost;
    private Kniha kniha;
    private Hrac hrac;

    @BeforeEach
    void setUp() {
        mistnost = new Knihovna("knihovna",null);
        hrac = new Hrac("Tester",5,mistnost,6);
        kniha = new Kniha("KnihaTestovaci",mistnost,false);
        hrac.setCtenaKniha(kniha);
        hrac.setCte(true);

        kniha.strany = new HashMap<>();
        kniha.setStranka(1);
        kniha.strany.put(1, "Strana 1");
        kniha.strany.put(2, "Strana 2");
        kniha.strany.put(3, "Strana 3");
    }


    @Test
    void prvniStranaTest() {
        kniha.setStranka(1);
        System.out.println(kniha.strany.size());
        assertEquals("Jste na první straně", kniha.zobrazeniStrany("-", hrac));
    }

    @Test
    void listovaniTest() {
        kniha.setStranka(0);
        assertEquals("Strana 1", kniha.zobrazeniStrany("+", hrac));
        assertEquals("Strana 2", kniha.zobrazeniStrany("+", hrac));
        assertEquals("Strana 3", kniha.zobrazeniStrany("+", hrac));
    }

    @Test
    void posledniStranaTest() {
        kniha.zobrazeniStrany("+", hrac);
        kniha.zobrazeniStrany("+", hrac);

        assertEquals("Jste na poslední straně", kniha.zobrazeniStrany("+", hrac));
    }
    @Test
    void testNeplatnyVstup() {
        assertEquals("Muzete zadat pouze +/-", kniha.zobrazeniStrany("x", hrac));
    }
}