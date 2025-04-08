import java.util.Scanner;

public class Asterisques {
    public static void main(String[] args) {
    	Scanner entree = new Scanner(System.in);
    	System.out.println("Entrer une valeur de N : ");
    	int n = entree.nextInt();
    	
        affichage(n);
        entree.close();
    }

    public static void affichage(int n) {
    	for (int i = 0 ; i < n +1 ; i++) {
    		for (int x = 0 ; x < i; x++) {
    			System.out.print("*");
    		}
    		System.out.println();
    	}
    	for (int j = 0 ; j < n + 1 ; j++) {
    		for (int y = 0 ; y < n ; y++) {
    			
    		}
    	}
    }
}
