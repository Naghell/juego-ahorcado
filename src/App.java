
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String secretWord;
        int attempts = 0;
        int maxAttempts = 10;
        boolean win = false;

        System.out.println("¡Bienvenido al juego del ahorcado!");
        System.out.println("Para iniciar a jugar, un jugador debe");
        System.out.println("ingresar la palabra secreta y el");
        System.out.println("otro adivinar (según el indicador).");
        System.out.println("");
        System.out.println("Ingrese la palabra para adivinar:");
        secretWord = scanner.next();

        char[] guessedLetters = new char[secretWord.length()];

        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        while (!win && attempts < maxAttempts) {
            boolean correctLetter = false;

            System.out.println("Palabra: " + String.valueOf(guessedLetters));
            System.out.println("Ingresa la letra: ");

            char letter = scanner.next().charAt(0);

            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    guessedLetters[i] = letter;
                    correctLetter = true;
                }
            }

            if (!correctLetter) {
                attempts++;
                System.err.println("¡Letra incorrecta! Tu quedan " + (maxAttempts - attempts) + " intentos.");
            }

            if (String.valueOf(guessedLetters).equals(secretWord)) {
                win = true;
                System.out.println("Adivinaste la palabra: " + secretWord + ". ¡Felicitaciones!");
            }
        }
        if (!win) {
            System.out.println("¡No lograste adivinar la palabra, buena suerte en la próxima!");
        }
        scanner.close();
    }
}
