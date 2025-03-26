package Objekty;

import Mistnosti.Mistnost;
import Mistnosti.Sklep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TrezorTest {
    private Trezor trezor;
    private Mistnost sklep;

    @BeforeEach
    void setUp() throws IOException {
        sklep = new Sklep("sklep",null);
        trezor = new Trezor("trezor",sklep,null,1234,false);
    }

    /**
     * Otestuje zda metoda pro odemknutí trezoru je funkční.
     */

    @Test
    void otevreniTrezoru() {
        String kod = "1234";
        InputStream vstup = new ByteArrayInputStream(kod.getBytes());
        System.setIn(vstup);
        assertTrue(trezor.otevreniTrezoru());
    }
    /**
     * Otestuje zda metoda pro odemknutí trezoru je nefunkční.
     */
    @Test
    void otevreniTrezoruSpatnyKod() {
        String kod = "8888\nzpet";
        InputStream vstup = new ByteArrayInputStream(kod.getBytes());
        System.setIn(vstup);
        assertFalse(trezor.otevreniTrezoru());

    }
}