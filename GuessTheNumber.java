import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    int numberToGuess = random.nextInt(100) + 1;
    int userGuess = 0;
    int attempts = 0;

    System.out.println("Welcome to the Number Guessing Game! ");
    System.out.println("Guess a number between 1 to 100.");

    while (userGuess != numberToGuess) {
      System.out.println("Enter your guess: ");
      userGuess = sc.nextInt();
      attempts++;

      if (userGuess < numberToGuess) {
        System.out.println("Too low! Try again.");
      } else if (userGuess > numberToGuess) {
        System.out.println("Too high! Try again.");
      } else {
        System.out.println("Congratulations! You guessed the number in " + attempts + " attempts. Yayyyyyy!!!");
      }
    }
    sc.close();
  }
}