package HangMan;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
  public static void main(String[] args) throws FileNotFoundException {  
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("1 or 2 players?");
    String players = keyboard.nextLine();
    
    String given_word;
    
    if (players.equals("1")) {
        //reading from file for random word for single player
      Scanner scanner = new Scanner(new File("C:\\Users\\Asus\\Desktop\\PROJECTS\\HangMan\\HangMan\\words.txt"));
      
      List<String> words = new ArrayList<>();//we add all word to a list
      
      while (scanner.hasNext()) {
        words.add(scanner.nextLine());
      }
      
      Random rand = new Random();
      given_word = words.get(rand.nextInt(words.size()));
    }
    else {
      System.out.println("Player 1, please enter your word:");
      given_word = keyboard.nextLine();
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//space for second player not to see the word
      System.out.println("Ready for player 2! Good luck!");
    }
    
    //System.out.println(word);
    
    List<Character> playerGuesses = new ArrayList<>();
    
    Integer wrongCount = 0;
    
    while(true) {
      printHangedMan(wrongCount);
      
      if (wrongCount >= 6) {
        System.out.println("You lose!");
        System.out.println("The word was: " + given_word);
        break;
      }
      
      printWordState(given_word, playerGuesses);
      if (!getPlayerGuess(keyboard, given_word, playerGuesses)) {
        wrongCount++;
      }
      
      if(printWordState(given_word, playerGuesses)) {
        System.out.println("You win!");
        break;
      }
      
      System.out.println("Please enter your guess for the word:");
      if(keyboard.nextLine().equals(given_word)) {
        System.out.println("You win!");
        break;
      }
      else {
        System.out.println("Nope! Try again.");
      }
    }
  }

  private static void printHangedMan(Integer wrongCount) {
    System.out.println(" -------");
    System.out.println(" |     |");
    if (wrongCount >= 1) {
      System.out.println(" O");
    }
    
    if (wrongCount >= 2) {
      System.out.print("\\ ");
      if (wrongCount >= 3) {
        System.out.println("/");
      }
      else {
        System.out.println("");
      }
    }
    
    if (wrongCount >= 4) {
      System.out.println(" |");
    }
    
    if (wrongCount >= 5) {
      System.out.print("/ ");
      if (wrongCount >= 6) {
        System.out.println("\\");
      }
      else {
        System.out.println("");
      }
    }
    System.out.println("");
    System.out.println("");
  }

  private static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
    System.out.println("Please enter a letter:");
    String letterGuess = keyboard.nextLine();
    playerGuesses.add(letterGuess.charAt(0));
    
    return word.contains(letterGuess);
  }

  private static boolean printWordState(String word, List<Character> playerGuesses) {
    int correctCount = 0;
    for (int i = 0; i < word.length(); i++) {
      if (playerGuesses.contains(word.charAt(i))) {
        System.out.print(word.charAt(i));
        correctCount++;
      }
      else {
        System.out.print("-");
      }
    }
    System.out.println();
    
    return (word.length() == correctCount);
  }
}