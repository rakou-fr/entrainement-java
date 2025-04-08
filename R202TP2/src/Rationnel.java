
public class Rationnel {

    public static long pgcd(long a, long b) throws IllegalArgumentException {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Les deux entiers sont nuls");
        }
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }
        while (a != b) {
            if (a < b) {
                b = b - a; // b-=a
            } else {
                a = a - b; // a-=b
            }
        }
        return a;
    }

    private final long numérateur;
    private final long dénominateur;

    public Rationnel(long numérateur, long dénominateur)
            throws IllegalArgumentException {
        if (numérateur < 0) {
            throw new IllegalArgumentException("numérateur négatif");
        }
        if (dénominateur <= 0) {
            throw new IllegalArgumentException("dénominateur négatif ou nul");
        }
        this.numérateur = numérateur;
        this.dénominateur = dénominateur;
    }

    public Rationnel somme(Rationnel r) {
        long n = this.numérateur * r.dénominateur
                + r.numérateur * this.dénominateur;
        long d = this.dénominateur * r.dénominateur;
        return new Rationnel(n, d);
    }

    public long getNumérateur() {
        return this.numérateur;
    }

    public Rationnel racineCarre(Rationnel r) {
    	Rationnel u_i = this;
    	for (int i = 0; i < 4; i++) {
    		Rationnel invUi = new Rationnel(this.numérateur * u_i.getDénominateur(), u_i.getNumérateur());
    		Rationnel somme = u_i.somme(invUi);
    		u_i = new Rationnel(somme.getNumérateur(), 2 * somme.getDénominateur());
    	}
    	
    	return u_i.réduction();
    }
    
    public long getDénominateur() {
        return this.dénominateur;
    }

    public Rationnel division(Rationnel r) {
    	if (r.numérateur == 0) {
    		throw new IllegalArgumentException("Division par 0 impossible");
    	}
    	
		return new Rationnel(this.numérateur * r.dénominateur, this.dénominateur * r.numérateur);
    }
    
	public Rationnel réduction() {
		long p = Rationnel.pgcd(this.numérateur, this.dénominateur);
		return new Rationnel(this.numérateur / p, this.dénominateur / p);
	}

    public Rationnel produit(Rationnel r) {
    	return new Rationnel(this.numérateur * r.numérateur, this.dénominateur * r.dénominateur);
    }

    @Override
    public String toString() {
        Rationnel formeReduite = this.réduction();
        return formeReduite.numérateur + "/" + formeReduite.dénominateur;
    }
    
}
