// Import required packages
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class guessTheNumberGUI extends JFrame implements ActionListener {

  // Declare components and game state variables
  private JTextField guessField;
  private JLabel feedbackLabel;
  private int numberToGuess;
  private int attempts;

  // Constructor: sets up the GUI and initializes game state
  public guessTheNumberGUI() {
    // Set window title and size
    setTitle("Number Guessing Game !");
    setSize(400, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new GridLayout(4, 1, 10, 10)); // Use GridLayout: 4 rows, 1 column, with spacing

    // Generate a random number between 1 and 100
    numberToGuess = new Random().nextInt(100) + 1;
    attempts = 0;

    add(new JLabel("Guess a number between 1 and 100:"));// Add input label

    // Create and add text field for user input
    guessField = new JTextField();
    add(guessField);

    // Create and add guess button
    JButton guessBtn = new JButton("Submit Guess");
    guessBtn.addActionListener(this); // Set action listener to handle button click
    add(guessBtn);

    // Create and add label for feedback
    feedbackLabel = new JLabel("Start guessing...");
    add(feedbackLabel);

    // Make the GUI visible
    setVisible(true);
  }

  // Event handler for the button click
  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      // Parse the user input to an integer
      int guess = Integer.parseInt(guessField.getText());
      attempts++; // Increase attempt count

      // Check the guess against the target number
      if (guess < numberToGuess) {
        feedbackLabel.setText("Too low! Attempts: " + attempts);
      } else if (guess > numberToGuess) {
        feedbackLabel.setText("Too high! Attempts: " + attempts);
      } else {
        feedbackLabel.setText("🎉 Correct! Number: " + numberToGuess + " in " + attempts + " attempts."); // Correct guess
      }
    } catch (NumberFormatException ex) {
      // If the user didn't enter a valid number
      JOptionPane.showMessageDialog(this, "Please enter a valid number!");
    }
  }

  // Main method to run the game
  public static void main(String[] args) {
    new guessTheNumberGUI(); // Create and show the game window
  }
}
