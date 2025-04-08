import java.util.Scanner;

public class ApplicationMonome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        Monome monome1 = new Monome(0.0F, 0);
        Monome monome2 = new Monome(0.0F, 0);
        
        int choix;
        
        do {
            System.out.println("Quel est votre choix :");
            System.out.println("1- modifier le premier monôme");
            System.out.println("2- modifier le deuxième monôme");
            System.out.println("3- afficher le premier monôme");
            System.out.println("4- afficher le deuxième monôme");
            System.out.println("5- calculer la somme des 2 monômes");
            System.out.println("6- calculer le produit des 2 monômes");
            System.out.println("7- calculer la dérivée du premier monôme");
            System.out.println("8- calculer la dérivée du deuxième monôme");
            System.out.println("9- quitter l'application");
            System.out.print("Entrez votre choix : ");
            
            choix = scanner.nextInt();
            
            switch (choix) {
                case 1:
                    System.out.print("Entrez le coefficient du premier monôme : ");
                    float coef1 = scanner.nextFloat();
                    System.out.print("Entrez l'exposant du premier monôme : ");
                    int exp1 = scanner.nextInt();
                    monome1 = new Monome(coef1, exp1);
                    System.out.println("Premier monôme modifié.");
                    break;
                    
                case 2:
                    System.out.print("Entrez le coefficient du deuxième monôme : ");
                    float coef2 = scanner.nextFloat();
                    System.out.print("Entrez l'exposant du deuxième monôme : ");
                    int exp2 = scanner.nextInt();
                    monome2 = new Monome(coef2, exp2);
                    System.out.println("Deuxième monôme modifié.");
                    break;
                    
                case 3:
                    System.out.println("Premier monôme : " + monome1.toString());
                    break;
                    
                case 4:
                    System.out.println("Deuxième monôme : " + monome2.toString());
                    break;
                    
                case 5:
                    try {
                        Monome somme = monome1.somme(monome2);
                        System.out.println("Somme des deux monômes : " + somme.toString());
                    } catch (ArithmeticException e) {
                        System.out.println("Erreur : les monômes ont des exposants différents.");
                    }
                    break;
                    
                case 6:
                    Monome produit = monome1.produit(monome2);
                    System.out.println("Produit des deux monômes : " + produit.toString());
                    break;
                    
                case 7:
                    System.out.println("Dérivée du premier monôme : " + monome1.dérivée().toString());
                    break;
                    
                case 8:
                    System.out.println("Dérivée du deuxième monôme : " + monome2.dérivée().toString());
                    break;
                    
                case 9:
                    System.out.println("Quitter l'application.");
                    break;
                    
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
            
        } while (choix != 9);

        scanner.close();
    }
}
