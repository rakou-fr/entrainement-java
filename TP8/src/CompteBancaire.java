public class CompteBancaire extends Compte {
	
    private String numéro;

    public CompteBancaire(String numéro) {
        this.numéro = numéro;
    }

    public String getNuméro() {
        return this.numéro;
    }

    @Override
    public String toString() {
        return "Numéro : " + this.getNuméro() + ", " + super.toString();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numéro == null) ? 0 : numéro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CompteBancaire)) {
			return false;
		}
		CompteBancaire other = (CompteBancaire) obj;
		if (numéro == null) {
			if (other.numéro != null) {
				return false;
			}
		} else if (!numéro.equals(other.numéro)) {
			return false;
		}
		return true;
	}
	public class Test {
		
	}
}
