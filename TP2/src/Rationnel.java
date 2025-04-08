import java.util.Scanner;

public class Rationnel{
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
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Entrée A et B : ");
		long a = scanner.nextLong();
		long b = scanner.nextLong();
		System.out.print("Dénominateur = " + a + "\nnumérateur = " + b + "\nRésultat : " + pgcd(a, b));
	}
}