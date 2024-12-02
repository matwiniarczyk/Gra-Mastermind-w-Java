import java.util.Scanner;
import java.util.Random;

public class MasterMind{
    public static void main(String args[]) {
        
        System.out.println("Witaj w grze MasterMind!");
        System.out.println("Zgadnij czterocyfrowy kod składający się z liczb od 1 do 6.");
        
        Random rand = new Random();
        
        int codeLength = 4;
        int maxNumber = 6;
        int[] secretCode = new int[codeLength];
        
        Scanner scann = new Scanner(System.in);
        
        boolean guessed = false;
        
         for (int i = 0; i < codeLength; i++) {
            secretCode[i] = rand.nextInt(maxNumber) + 1;
            System.out.print(secretCode[i]);
        }
        
        System.out.println("");
        
        while(guessed == false) {
            System.out.println("Wprowadź swoją próbę: ");
            String guess = scann.nextLine();
            
            
            int[] guessCheck = new int[codeLength];
            
            try{
                if (guess != null && guess.length() != codeLength) {
                    throw new NumberFormatException();
                }
                for (int i = 0; i < codeLength; i++) {
                    guessCheck[i] = Character.getNumericValue(guess.charAt(i));
                    if (guessCheck[i] < 1 || guessCheck[i] > maxNumber) {
                    throw new NumberFormatException();
                    }
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Wprowadzony kod musi składać się z " + codeLength + " liczb od 1 do " + maxNumber + "!");
            }
            
            
            int correctPosition = 0;
            int correctDigit = 0;
            
            boolean[] usedInSecret = new boolean[codeLength];
            boolean[] usedInGuess = new boolean[codeLength];
            
            for (int i = 0; i < codeLength; i++) {
                if (guessCheck[i] == secretCode[i]) {
                    correctPosition++;
                    usedInSecret[i] = true;
                    usedInGuess[i] = true;
                }
            }
            
            for (int i = 0; i < codeLength; i++) {
                if (usedInGuess[i] != true) {
                    for (int j = 0; j < codeLength; j++) {
                        if (usedInSecret[j] == false && usedInGuess[i] == usedInSecret[j]) {
                            correctDigit++;
                            usedInGuess[i] = true;
                            usedInSecret[j] = true;
                        }
                    }
                }
            }
            
            if (correctPosition == codeLength) {
                System.out.println("GRATULACJA UŻYTKOWNIKU!");
                guessed = true;
            } else {
                System.out.println("Poprawne cyfry na poprawnej pozycji: " + correctPosition);
                System.out.println("Poprawne cyfry na niepoprawnej pozycji: " + correctDigit);
            }
            
        }
        
        scann.close();
        
    }
}
























































 











