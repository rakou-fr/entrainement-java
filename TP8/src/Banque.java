import java.util.ArrayList;
import java.util.List;

public class Banque {
    private String libelle;
    private List<CompteBancaire> comptes;

    public Banque(String libelle) {
        this.libelle = libelle;
        this.comptes = new ArrayList<>();
    }

    public String getLibelle() {
        return libelle;
    }

    public void ouvrir(String numero, float dépotInitial) {
        if (!estCompteExistant(numero)) {
            comptes.add(new CompteBancaire(numero));
            deposer(numero, dépotInitial);
        }
    }

    public void fermer(String numero) {
        CompteBancaire compte = getCompte(numero);
        if (compte != null && compte.solde() == 0) {
            comptes.remove(compte);
        }
    }

    public float solde() {
        float total = 0.0f;
        for (CompteBancaire c : comptes) {
            total += c.solde();
        }
        return total;
    }

    public void deposer(String numero, float valeur) {
        if (valeur >= 0) {
            CompteBancaire compte = getCompte(numero);
            if (compte != null) {
                compte.déposer(valeur);
            }
        }
    }

    public void retirer(String numero, float valeur) {
        if (valeur >= 0) {
            CompteBancaire compte = getCompte(numero);
            if (compte != null) {
                compte.retirer(valeur);
            }
        }
    }

    public boolean estCompteExistant(String numero) {
        return getCompte(numero) != null;
    }

    public CompteBancaire getCompte(String numero) {
        for (CompteBancaire c : comptes) {
            if (c.getNuméro().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[Banque : ");
        sb.append(libelle).append("\n");
        for (CompteBancaire c : comptes) {
            sb.append("Numéro : ").append(c.getNuméro())
              .append(", Crédit : ").append(c.solde())
              .append(", Débit : 0.0\n");
        }
        sb.append("]");
        return sb.toString();
    }
}