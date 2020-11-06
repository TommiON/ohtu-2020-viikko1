package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        varasto2 = new Varasto(0);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);

        varasto2 = new Varasto(0.0);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuusJaAlkusaldo() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);

        varasto2 = new Varasto(0, 0);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);

        varasto2 = new Varasto(10, 0);
        assertEquals(10, varasto2.getTilavuus(), vertailuTarkkuus);

        varasto2 = new Varasto(10, 9);
        assertEquals(9, varasto2.getSaldo(), vertailuTarkkuus);

        varasto2 = new Varasto(10, 11);
        assertEquals(10, varasto2.getSaldo(), vertailuTarkkuus);

        varasto2 = new Varasto(10, -1);
        assertEquals(-1, varasto2.getSaldo(), vertailuTarkkuus);
    }


    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);

        varasto2 = new Varasto(10);
        varasto2.lisaaVarastoon(-1);
        // implicit assertion

        varasto2 = new Varasto(10,8);
        varasto2.lisaaVarastoon(3);
        assertEquals(10, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);

        varasto.otaVarastosta(-1);
        // implicit assertion

        // muutos
        varasto2 = new Varasto(10, 2);
        assertEquals(2, varasto2.otaVarastosta(100), vertailuTarkkuus);

    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void tulostaaMerkkijonoesityksenOikein() {
        varasto2 = new Varasto(10, 0);
        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto2.toString());
    }

}