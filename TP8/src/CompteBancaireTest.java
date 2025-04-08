import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CompteBancaireTest {
	private CompteBancaire c;
	private CompteBancaire cNumNull;
	
	@Before
	public void setUp() throws Exception{ 
		this.c = new CompteBancaire("001");
		this.cNumNull = new CompteBancaire(null);
		}
	@Test
	public void testEqualsReflexivite() {
		assertTrue(this.c.equals(this.c));
	}
	@Test
	public void testEqualsAutreClass() {
		assertFalse(this.c.equals(new Object()));
	}
	@Test
	public void testEqualsNull() {
		assertFalse(this.c.equals(null));
	}
	@Test
	public void testEqualsNumeroNullEtNumeroNonNull() {
		assertFalse(this.c.equals(this.cNumNull));
	
	}
	@Test 
	public void testEqualsNumeroNull() {
		CompteBancaire autreCNumNull = new CompteBancaire("002");
		assertTrue(this.cNumNull.equals(autreCNumNull));
	}
	
	@Test
	public void testEqualsNumeroEgaux() {
		CompteBancaire autreC = new CompteBancaire("001");
		assertTrue(this.c.equals(autreC));
	}

}