import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner keyboard = new Scanner(System.in);//keyboard for user guesses

        System.out.println("1 or 2 players?");
        String players = keyboard.nextLine();

        String word_given;
        if(players.equals("1")){
        //reading from file words for SinglePlayer
        Scanner scanner = new Scanner(new File("C:/Users/Asus/Desktop/PROJECTS/HangMan/HangManApp/words.txt"));
        
        
        List<String> words = new ArrayList<>();
        //adding all the words into a List

        while (scanner.hasNext()){
            //System.out.println(scanner.nextLine());
            words.add(scanner.nextLine());
        }

        Random rand = new Random();
        //getting a random word from that list
        word_given = words.get(rand.nextInt(words.size()));

        }
        else{
          System.out.println("Plyer 1, please enter your word:");
          word_given = keyboard.nextLine();  
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//lines because we want the second player not to see the word
          System.out.println("Ready for player 2! Good luck");
        }
        
        //System.out.println(word_given);
        //we will not show the word in the beggining
        List<Character> playerGuesses = new ArrayList<>();


    int wrongCount = 0;
    while(true){

        printHangedMan(wrongCount);

        if(wrongCount >= 6) {
            System.out.println("You lose!");
            System.out.println("The word was: " + word_given);
            break;
        }


        printWordState(word_given, playerGuesses);//printing every character with "-"
        if (!getPlayerGuess(keyboard, word_given, playerGuesses)){
            wrongCount++;
        }
                
        if(printWordState(word_given, playerGuesses)){
            System.out.println("You win!");
            break;
        }

        System.out.println("Please enter your guess for the word");
        if(keyboard.nextLine().equals(word_given)){
            System.out.println("You win!");
            break;
        }
        else{
            System.out.println("Nope! TRy again.");
        }
    }

}

    private static void printHangedMan(int wrongCount) {
        System.out.println(" ------- ");
        System.out.println(" |     | ");
        if(wrongCount >= 1 ) {
            System.out.println(" O");
        }
        if(wrongCount >= 2 ){
            System.out.print("\\ ");
            if(wrongCount >= 3){
                System.out.println("/");
            }else {
                System.out.println("");
            }
        }
        if(wrongCount >= 4 ) {
            System.out.println(" |");
        }
        if(wrongCount >= 5 ){
            System.out.print("/ ");
            if(wrongCount >= 6){
                System.out.println("\\");
            }else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
    }

    private static boolean getPlayerGuess(Scanner keyboard, String random_word, List<Character> playerGuesses) {
        System.out.println("Please enter a letter:");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));//if the user writes more than one charcater we will take the first one

        return random_word.contains(letterGuess);
    }

    private static boolean printWordState(String random_word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < random_word.length(); i++) {
            if (playerGuesses.contains(random_word.charAt(i))) {
                 System.out.print(random_word.charAt(i));
                 correctCount++;
                }
            else {
                System.out.print("-");
            }
        }
        System.out.println();

        return(random_word.length() == correctCount);
    }


    
}