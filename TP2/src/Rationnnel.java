public class Rationnnel {
	private final long numérateur;
	private final long dénominateur;
	
	private static long pgcd(long a, long b) throws IllegalArgumentException
	{
		if (a==0L && b == 0L) {
			throw new IllegalArgumentException("Les deux entiers sont nuls");
		}
		if (a == 0L || b == 0L) {
			return Math.max(a, b);
		}
		while(a != b) {
			if (a > b) {
				a -= b;
			} else {
				b -= a;
			}
		}
		return a;
	}
	
	public Rationnnel(long numérateur, long dénominateur) {
		if (dénominateur == 0L) {
			throw new ArithmeticException("Le dénominateur ne peut pas etre zero !");
		}
		
		if (dénominateur < 0L) {
			numérateur -= numérateur;
			dénominateur -= dénominateur;
		}
		
		long p = pgcd(numérateur, dénominateur);
		this.numérateur = numérateur / p;
		this.dénominateur = dénominateur /p;
	}
	
	public long getNumérateur() {
		return this.numérateur;
	}
	
	public long getDénominateur() {
		return this.dénominateur;
	}
	
	public Rationnnel réduction() {
		long p = Rationnnel.pgcd(this.numérateur, this.dénominateur);
		return new Rationnnel(this.numérateur / p, this.dénominateur / p);
	}
	
	public Rationnnel somme(Rationnnel r) {
		return new Rationnnel(this.numérateur * r.dénominateur 
				+ r.numérateur * this.dénominateur, this.dénominateur * r.numérateur);
	}
	
	public Rationnnel produit(Rationnnel r) {
		return new Rationnnel(this.numérateur * r.numérateur, this.dénominateur * r.dénominateur);
	}
	
	
	@Override
	public String toString() {
		Rationnnel réduit = this.réduction();
		return réduit.numérateur + "/" + réduit.dénominateur;
	}
	
}