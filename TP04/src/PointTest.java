import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PointTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPointFloatFloat() {
        Point point = new Point(2.0F, 3.0F);
        assertEquals(2.0F, point.getAbscisse(), 0.001);
        assertEquals(3.0F, point.getOrdonnée(), 0.001);
    }

    @Test
    public void testPoint() {
        Point point = new Point();
        assertEquals(0.0F, point.getAbscisse(), 0.001);
        assertEquals(0.0F, point.getOrdonnée(), 0.001);
    }

    @Test
    public void testGetAbscisse() {
        Point point = new Point(1.0F, 1.0F);
        assertEquals(1.0F, point.getAbscisse(), 0.001);
    }

    @Test
    public void testGetOrdonnée() {
        Point point = new Point(1.0F, 1.0F);
        assertEquals(1.0F, point.getOrdonnée(), 0.001);
    }

    @Test
    public void testTranslater() {
        Point point = new Point(1.0F, 1.0F);
        point.translater(2.0F, 3.0F);
        assertEquals(3.0F, point.getAbscisse(), 0.001);
        assertEquals(4.0F, point.getOrdonnée(), 0.001);
    }

    @Test
    public void testMettreAEchelle() {
        Point point = new Point(2.0F, 3.0F);
        point.mettreAEchelle(2.0F);
        assertEquals(4.0F, point.getAbscisse(), 0.001);
        assertEquals(6.0F, point.getOrdonnée(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMettreAEchelleAvecFacteurNegatif() {
        Point point = new Point(1.0F, 1.0F);
        point.mettreAEchelle(-1.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMettreAEchelleAvecFacteurZero() {
        Point point = new Point(1.0F, 1.0F);
        point.mettreAEchelle(0.0F);
    }
}
