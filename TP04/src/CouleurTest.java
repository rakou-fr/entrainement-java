import static org.junit.Assert.*;
import org.junit.Test;

public class CouleurTest {

    @Test
    public void testCouleur() {
        Couleur couleur = new Couleur(255, 255, 255);
        assertEquals(255, couleur.getRouge());
        assertEquals(255, couleur.getVert());
        assertEquals(255, couleur.getBleu());
    }

    @Test
    public void testRouge() {
        Couleur couleur = Couleur.rouge();
        assertEquals(255, couleur.getRouge());
        assertEquals(0, couleur.getVert());
        assertEquals(0, couleur.getBleu());
    }

    @Test
    public void testVert() {
        Couleur couleur = Couleur.vert();
        assertEquals(0, couleur.getRouge());
        assertEquals(255, couleur.getVert());
        assertEquals(0, couleur.getBleu());
    }

    @Test
    public void testBleu() {
        Couleur couleur = Couleur.bleu();
        assertEquals(0, couleur.getRouge());
        assertEquals(0, couleur.getVert());
        assertEquals(255, couleur.getBleu());
    }

    @Test
    public void testGetRouge() {
        Couleur couleur = new Couleur(255, 0, 0);
        assertEquals(255, couleur.getRouge());
    }

    @Test
    public void testGetVert() {
        Couleur couleur = new Couleur(0, 255, 0);
        assertEquals(255, couleur.getVert());
    }

    @Test
    public void testGetBleu() {
        Couleur couleur = new Couleur(0, 0, 255);
        assertEquals(255, couleur.getBleu());
    }

    @Test
    public void testValeurRVB() {
        Couleur couleur = new Couleur(255, 0, 0);
        assertEquals(16711680, couleur.valeurRVB());
    }

    @Test
    public void testSetRouge() {
        Couleur couleur = new Couleur(0, 0, 0);
        couleur.setRouge(128);
        assertEquals(128, couleur.getRouge());
    }

    @Test
    public void testSetVert() {
        Couleur couleur = new Couleur(0, 0, 0);
        couleur.setVert(128);
        assertEquals(128, couleur.getVert());
    }

    @Test
    public void testSetBleu() {
        Couleur couleur = new Couleur(0, 0, 0);
        couleur.setBleu(128);
        assertEquals(128, couleur.getBleu());
    }
}
