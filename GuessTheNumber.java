package coder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessTheNumber extends JFrame {

    private int secretNumber;
    private int attempts;

    private JTextField guessField;
    private JLabel feedbackLabel;

    public GuessTheNumber() {
        super("Guess the Number Game");
        secretNumber = generateRandomNumber();
        attempts = 0;

        setupUI();
    }

    private void setupUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel instructionLabel = new JLabel("Enter your guess (between 1 and 100):");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        feedbackLabel = new JLabel("");

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.add(instructionLabel);
        inputPanel.add(guessField);
        inputPanel.add(guessButton);

        add(inputPanel, BorderLayout.NORTH);
        add(feedbackLabel, BorderLayout.CENTER);
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(guessField.getText());
            attempts++;

            if (userGuess == secretNumber) {
                displayWinnerMessage();
            } else if (userGuess < secretNumber) {
                feedbackLabel.setText("Too low! Try again.");
            } else {
                feedbackLabel.setText("Too high! Try again.");
            }
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("Invalid input. Please enter a number.");
        }
    }

    private void displayWinnerMessage() {
        feedbackLabel.setText(String.format("Congratulations! You guessed the number %d in %d attempts.", secretNumber, attempts));
        guessField.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessTheNumber().setVisible(true);
            }
        });
    }
}
