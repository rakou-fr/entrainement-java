import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner entree = new Scanner(System.in);
    	int a;
    	while (true) {
    		System.out.println("Coefficiant A :");
    		a = entree.nextInt();
    		if (a != 0) {
    			break;
    		}
    	}
    	System.out.println("Coefficiant B :");
    	int b = entree.nextInt();
    	System.out.println("Coefficiant C :");
    	int c = entree.nextInt();
    	
        calculerDelta(a, b, c);
        entree.close();
    }

    public static void calculerDelta(int a, int b, int c) {
        if (a != 0) {
            int delta = (b * b) - (4 * a * c);
            System.out.println("Le discriminant (delta) est : " + delta);
            if (delta > 0) {
            	int racine = (int) Math.sqrt(delta);
            	
            	double x1 = ((-b) + racine) / (2 * a);
            	double x2 = ((-b) - racine) / (2 * a);
            	System.out.println("Les solutions\nx_1 : " + x1 + "\nx_2 : " + x2);
            } 
            else if (delta == 0) {
            	int x = -b/(2*a);
            	System.out.println("L'unique solution X est : " + x);
            }
            else {
            	System.out.println("L'équation d'admet aucune solution réelle car Delta < 0 !!");
            }
            
        } else {
            System.out.println("A doit être supérieur à 0");
        }
    }
}
