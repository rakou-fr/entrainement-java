import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MonomeTest {

    private Monome m;
    private Monome nul;

    @Before
    public void setUp() throws Exception {
        this.m = new Monome(1.0F, 2);
        this.nul = new Monome(0.0F, 0);
    }

    @After
    public void tearDown() throws Exception {
        this.m = null;
        this.nul = null;
    }

    @Test
    public void testConstructeurCoefficient() {
        assertEquals(1.0F, this.m.getCoefficient(), 0.0F);
    }

    @Test
    public void testConstructeurExposant() {
        assertEquals(2, this.m.getExposant());
    }

    @Test
    public void testEstNulMonômeNul() {
        assertTrue(this.nul.estNul());
    }


    @Test
    public void testEstNulMonômeNonNul() {
        assertFalse(this.m.estNul());
    }


    @Test
    public void testSommeMonômes() {
        Monome somme = this.m.somme(new Monome(1.1F, 2));
        assertEquals(this.m.getCoefficient() + 1.1F, somme.getCoefficient(),
                0.0F);
        assertEquals(this.m.getExposant(), somme.getExposant());
    }

    @Test
    public void testProduitMonômes() {
        Monome produit = this.m.produit(new Monome(1.1F, 2));
        assertEquals(this.m.getCoefficient() * 1.1F, produit.getCoefficient(),
                0.0F);
        assertEquals(this.m.getExposant() + 2, produit.getExposant());
    }

    @Test
    public void testDeriveeMonômeNul() {
        assertTrue(this.nul.dérivée().estNul());
    }

    @Test
    public void testDeriveeMonômeNonNul() {
        Monome dérivée = this.m.dérivée();
        assertEquals(this.m.getCoefficient() * this.m.getExposant(),
                dérivée.getCoefficient(), 0.0F);
        assertEquals(this.m.getExposant() - 1, dérivée.getExposant());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurExposantNegatif() {
        new Monome(0.0F, -1);
    }

    @Test(expected = ArithmeticException.class)
    public void testSomme2MonômesExposantsDifferents() {
        this.m.somme(new Monome(1.0F, 3));
    }
    
    @Test
    public void testToString() {
        assertEquals("0.0xe5", new Monome(0.0F, 5).toString());
        assertEquals("-10.0xe5", new Monome(-10.0F, 5).toString());
        assertEquals("-xe5", new Monome(-1.0F, 5).toString());
        assertEquals("-1.0", new Monome(-1.0F, 0).toString());
        assertEquals("-10.0x", new Monome(-10.0F, 1).toString());
        assertEquals("-x", new Monome(-1.0F, 1).toString());
        assertEquals("1.0", new Monome(1.0F, 0).toString());
        assertEquals("10.0xe5", new Monome(10.0F, 5).toString());
        assertEquals("+xe5", new Monome(1.0F, 5).toString());
        assertEquals("+1.0", new Monome(1.0F, 0).toString());
        assertEquals("+10.0x", new Monome(10.0F, 1).toString());
        assertEquals("+x", new Monome(1.0F, 1).toString());
        assertEquals("10.0", new Monome(10.0F, 0).toString());
    }



}
