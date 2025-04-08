import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PointColoréTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPointColoréFloatFloatIntIntInt() {
		PointColoré pointColoré = new PointColoré(1.0F, 1.0F, 255, 0, 0);
		assertEquals(255, pointColoré.getNuanceRouge());
		assertEquals(0, pointColoré.getNuanceBleu());
		assertEquals(0, pointColoré.getNuanceVert());
	}

	@Test
	public void testPointColoré() {
		PointColoré pointColoré = new PointColoré();
		assertEquals(0, pointColoré.getNuanceRouge());
		assertEquals(0, pointColoré.getNuanceBleu());
		assertEquals(0, pointColoré.getNuanceVert());
	}

	@Test
	public void testGetNuanceRouge() {
		PointColoré pointColoré = new PointColoré(1.0F, 1.0F, 255, 0, 0);
		assertEquals(255, pointColoré.getNuanceRouge());
	}

	@Test
	public void testGetNuanceVert() {
		PointColoré pointColoré = new PointColoré(1.0F, 1.0F, 0, 255, 0);
		assertEquals(255, pointColoré.getNuanceVert());
	}

	@Test
	public void testGetNuanceBleu() {
		PointColoré pointColoré = new PointColoré(1.0F, 1.0F, 0, 0, 255);
		assertEquals(255, pointColoré.getNuanceBleu());
	}

	@Test
	public void testSetNuanceRouge() {
		PointColoré pointColoré = new PointColoré(1.0F, 1.0F, 0, 0, 0);
		pointColoré.setNuanceRouge(255);
		assertEquals(255, pointColoré.getNuanceRouge());
	}

	@Test
	public void testSetNuanceVert() {
		PointColoré pointColoré = new PointColoré(1.0F, 1.0F, 0, 0, 0);
		pointColoré.setNuanceVert(255);
		assertEquals(255, pointColoré.getNuanceVert());
	}

	@Test
	public void testSetNuanceBleu() {
		PointColoré pointColoré = new PointColoré(1.0F, 1.0F, 0, 0, 0);
		pointColoré.setNuanceBleu(255);
		assertEquals(255, pointColoré.getNuanceBleu());
	}

}
