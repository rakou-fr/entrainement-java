import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import corrigé.Banque;

public class BanqueTest {
    private Banque b;

    @Before
    public void setUp() throws Exception {
        this.b = new Banque("toto");
        this.b.ouvrir("c1", 0.0F);
        this.b.ouvrir("c2", 100.0F);
        this.b.ouvrir("c3", 10.0F);
    }

    @After
    public void tearDown() throws Exception {
        this.b = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOuvrirCompteExistant() {
        this.b.ouvrir("c1", 150.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOuvrirValeurNégative() {
        this.b.ouvrir("c4", -1.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFermerCompteInexistant() {
        this.b.fermer("c4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFermerSoldeNonNul() {
        this.b.fermer("c3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDéposerCompteInexistant() {
        this.b.deposer("c4", 10.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDéposerValeurNégative() {
        this.b.deposer("c1", -3.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirerCompteInexistant() {
        this.b.retirer("c4", 10.0F);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRetirerValeurNégative() {
        this.b.retirer("c1", -3.0F);
    }

    @Test
    public void testLibellé() {
        assertEquals(this.b.getLibelle(), "toto");
    }

    @Test
    public void testToStringBanqueContenantDesComptes() {
        assertEquals(
                "[Banque : toto\n" + "Numéro : c1, Crédit : 0.0, Débit : 0.0\n"
                        + "Numéro : c2, Crédit : 100.0, Débit : 0.0\n"
                        + "Numéro : c3, Crédit : 10.0, Débit : 0.0]",
                this.b.toString());
    }

    @Test
    public void testBanqueVideCréation() {
        Banque b2 = new Banque("titi");
        assertEquals("[Banque : titi]", b2.toString());
    }

    @Test
    public void testOuvrir() {
        this.b.ouvrir("c4", 20.0F);
        assertEquals(
                "[Banque : toto\n" + "Numéro : c1, Crédit : 0.0, Débit : 0.0\n"
                        + "Numéro : c2, Crédit : 100.0, Débit : 0.0\n"
                        + "Numéro : c3, Crédit : 10.0, Débit : 0.0\n"
                        + "Numéro : c4, Crédit : 20.0, Débit : 0.0]",
                this.b.toString());
    }

    @Test
    public void testFermer() {
        this.b.fermer("c1");
        assertEquals(
                "[Banque : toto\n"
                        + "Numéro : c2, Crédit : 100.0, Débit : 0.0\n"
                        + "Numéro : c3, Crédit : 10.0, Débit : 0.0]",
                this.b.toString());
    }

    @Test
    public void testDéposer() {
        this.b.deposer("c2", 50.0F);
        assertEquals(
                "[Banque : toto\n" + "Numéro : c1, Crédit : 0.0, Débit : 0.0\n"
                        + "Numéro : c2, Crédit : 150.0, Débit : 0.0\n"
                        + "Numéro : c3, Crédit : 10.0, Débit : 0.0]",
                this.b.toString());
    }

    @Test
    public void testRetirer() {
        this.b.retirer("c2", 150.0F);
        assertEquals(
                "[Banque : toto\n" + "Numéro : c1, Crédit : 0.0, Débit : 0.0\n"
                        + "Numéro : c2, Crédit : 100.0, Débit : 150.0\n"
                        + "Numéro : c3, Crédit : 10.0, Débit : 0.0]",
                this.b.toString());
    }

    @Test
    public void testCompteExistant() {
        assertTrue(this.b.estCompteExistant("c1"));
    }

    @Test
    public void testCompteInexistant() {
        assertFalse(this.b.estCompteExistant("c4"));
    }

    @Test
    public void testGetCompteInexistant() {
        assertNull(this.b.getCompte("c4"));
    }

    @Test
    public void testGetCompteExistant() {
        CompteBancaire c = this.b.getCompte("c2");
        assertEquals("Numéro : c2, Crédit : 100.0, Débit : 0.0", c.toString());
    }

    @Test
    public void testSolde() {
        this.b.retirer("c2", 150.0F);
        assertEquals(-40.0, this.b.solde(), 0.0F);
    }

    // TESTS AJOUTES
    @Ignore
    @Test
    public void testOuvrirCompteEpargne() {
        this.b.ouvrir("c5", 0.02F, 100.0F);
        assertEquals("[Banque : toto\n"
                + "Numéro : c1, Crédit : 0.0, Débit : 0.0\n"
                + "Numéro : c2, Crédit : 100.0, Débit : 0.0\n"
                + "Numéro : c3, Crédit : 10.0, Débit : 0.0\n"
                + "Numéro : c5, Crédit : 100.0, Débit : 0.0, Taux : 2.0%]",
                this.b.toString());
    }

    @Ignore
    @Test
    public void testDéposerCompteEpargne() {
        this.b.ouvrir("c5", 0.02F, 100.0F);
        this.b.deposer("c5", 40.0F);
        assertEquals(140.0F, this.b.getCompte("c5").solde(), 0.0F);
    }

    @Ignore
    @Test
    public void testRetirerCompteEpargne() {
        this.b.ouvrir("c5", 0.02F, 100.0F);
        this.b.retirer("c5", 40.0F);
        assertEquals(60.0F, this.b.getCompte("c5").solde(), 0.0F);
    }

    @Ignore
    @Test
    public void testFermerCompteEpargne() {
        this.b.ouvrir("c5", 0.02F, 100.0F);
        this.b.retirer("c5", 100.0F);
        this.b.fermer("c5");
        assertEquals(
                "[Banque : toto\n" + "Numéro : c1, Crédit : 0.0, Débit : 0.0\n"
                        + "Numéro : c2, Crédit : 100.0, Débit : 0.0\n"
                        + "Numéro : c3, Crédit : 10.0, Débit : 0.0]",
                this.b.toString());

    }

}
