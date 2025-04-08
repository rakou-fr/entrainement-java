public class ApplicationClient {

    public static void main(String[] args) throws FullStackException, EmptyStackException {
        String mot = "SALOPE"; 

        if (isPalindrome(mot)) {
            System.out.println(mot + " est un palindrome.");
        } else {
            System.out.println(mot + " n'est pas un palindrome.");
        }
    }

    public static boolean isPalindrome(String mot) throws FullStackException, EmptyStackException {
        PileBornee<Character> pile = new PileBornee<>(mot.length());

        for (int i = 0; i < mot.length(); i++) {
            pile.push(mot.charAt(i));
        }

        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) != pile.top()) {
                return false; 
            }
            pile.pop(); 
        }
        return true; 
    }
}
