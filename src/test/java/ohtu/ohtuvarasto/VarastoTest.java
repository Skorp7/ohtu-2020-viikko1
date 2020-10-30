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
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
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
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiOttaaAlleNollanMaaraa() {
        varasto.lisaaVarastoon(2);
        varasto.otaVarastosta(-1);
        assertEquals(2, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void eiVoiLisataAlleNollanMaaraa() {
        varasto.lisaaVarastoon(-2);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void eiAnnetaEnemmanKuinOn() {
        varasto.lisaaVarastoon(2);
        assertEquals(2, varasto.otaVarastosta(3), vertailuTarkkuus);
    }
    
    @Test
    public void merkkijonoOikein() {
        varasto.lisaaVarastoon(3);
        assertEquals("saldo = 3.0, vielä tilaa 7.0", varasto.toString());
    }
    
    @Test
    public void varastoEiTaytyYli() {
        varasto.lisaaVarastoon(5);
        varasto.lisaaVarastoon(6);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriEiAnnaAlleNollanTilavuutta() {
        Varasto uusi = new Varasto(-1);
        assertEquals(0, uusi.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void toinenKonstruktoriEiAnnaAlleNollanTilavuutta() {
        Varasto uusi = new Varasto(-1, 0);
        assertEquals(0, uusi.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void toinenKonstruktoriEiAnnaSaldonOllaYliTilavuuden() {
        Varasto uusi = new Varasto(2, 5);
        assertEquals(2, uusi.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void toinenKonstruktoriEiAnnaSaldonOllaAlleNollan() {
        Varasto uusi = new Varasto(2, -3);
        assertEquals(0, uusi.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void toinenKonstruktoriAsettaaSaldonOikein() {
        Varasto uusi = new Varasto(4, 1);
        assertEquals(1, uusi.getSaldo(), vertailuTarkkuus);
    }
    //testikommentti
}