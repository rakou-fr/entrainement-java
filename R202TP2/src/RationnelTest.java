import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class RationnelTest {

    @Test
    public void testConstructeur() {
        Rationnel r = new Rationnel(1, 2);
        assertEquals(1, r.getNumérateur());
        assertEquals(2, r.getDénominateur());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurNumerateurNegatif() {
        new Rationnel(-1, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurDenominateurNul() {
        new Rationnel(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurDenominateurNegatif() {
        new Rationnel(1, -10);
    }

    @Test
    public void testCalculPgcd() {
        assertEquals(3, Rationnel.pgcd(3, 3));
        assertEquals(3, Rationnel.pgcd(15, 3));
        assertEquals(3, Rationnel.pgcd(9, 3));
        assertEquals(3, Rationnel.pgcd(6, 3));
        assertEquals(3, Rationnel.pgcd(3, 15));
        assertEquals(5, Rationnel.pgcd(15, 10));
    }

    @Test
    public void testCalculPgcdCasLimite0() {
        assertEquals(5, Rationnel.pgcd(0, 5));
        assertEquals(5, Rationnel.pgcd(5, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculPgcdCasLimite00() {
        Rationnel.pgcd(0, 0);
    }

    @Test
    public void testRéduction() {
        Rationnel r = new Rationnel(15, 10).réduction();
        assertEquals(3, r.getNumérateur());
        assertEquals(2, r.getDénominateur());
    }

    @Test
    public void testRéductionCasLimite0() {
        Rationnel r = new Rationnel(0, 10).réduction();
        assertEquals(0, r.getNumérateur());
        assertEquals(1, r.getDénominateur());
    }

    @Test
    public void testSomme() {
        Rationnel s = new Rationnel(3, 5).somme(new Rationnel(2, 10));
        assertEquals(40, s.getNumérateur());
        assertEquals(50, s.getDénominateur());
    }

    @Test
    public void testProduit() {
        Rationnel p = new Rationnel(3, 5).produit(new Rationnel(2, 10));
        assertEquals(6, p.getNumérateur());
        assertEquals(50, p.getDénominateur());
    }

    @Test
    public void testRacineCarré() {
    	int a = 4;
    	Rationnel r = new Rationnel(a,a);
    	Rationnel racine2 = r.racineCarre(null);
    	
        System.out.println("V"+ a + " = " + racine2.getNumérateur() / racine2.getDénominateur());
    }
    
    @Test
    public void testDivision() {
        Rationnel d = new Rationnel(3, 5).division(new Rationnel(2, 10));
        assertEquals(30, d.getNumérateur());
        assertEquals(10, d.getDénominateur());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionPar0() {
        new Rationnel(3, 5).division(new Rationnel(0, 10));
    }

    @Test
    public void testToString() {
        assertEquals("3/5", new Rationnel(9, 15).toString());
        assertEquals("0/1", new Rationnel(0, 5).toString());
    }

}
