/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author utkua
 */
  public class RockPaperScissors {
    
    // Global scanner used in multiple methods
    static Scanner s;

    public static void main(String[] args) {
        
        // Store player choice
        int choice;
        // Store computer choice
        int compChoice;
        // Store player round number input, total number of rounds
        int rounds;
        // Store current round
        int roundCount;

        // Count ties, wins, losses
        int tieCount;
        int winCount;
        int lossCount;
        
        // Array of moves corresponding to choices
        String[] choices = {"Rock", "Paper", "Scissors"};
        // Boolean determining if game loop should occur again
        boolean playAgain = true;
        
        // Random determining computer move choice
        Random r = new Random();
        
        // Outer game loop, loops once each game
        while (playAgain) {
            // Reset all counts for new game
            tieCount = 0;
            winCount = 0;
            lossCount = 0;
            roundCount = 0;
            
            // Get round input from player
            rounds = chooseRounds();
            
            // Inner round loop, loops once per round
            while (roundCount < rounds) {
                // Output remaining rounds
                System.out.println("Remaining rounds: " + (rounds - roundCount));
                // Get player choice
                choice = chooseMove();
                // Random computer choice
                compChoice = r.nextInt(3) + 1;
                
                // If player and computer moves equal, tie
                if (compChoice == choice) {
                    // Print choices, result, and increment tie count to indicate tie
                    System.out.println();
                    System.out.println("Computer choice: " + choices[compChoice - 1] + " -- Your choice: " + choices[choice - 1]);
                    System.out.println("Tie\n");
                    tieCount++;
                } 
                // If player choice 1 above computer choice, mod 3 - mod 3 because 3 moves
                else if ((choice % 3) == (compChoice + 1) % 3) {
                    // Print choices, result, and increment win count to indicate win
                    System.out.println();
                    System.out.println("Computer choice: " + choices[compChoice - 1] + " -- Your choice: " + choices[choice - 1]);
                    System.out.println("Win\n");
                    winCount++;
                }
                // Otherwise computer wins
                else {
                    // Print choices, result, and increment loss count to indicate loss
                    System.out.println();
                    System.out.println("Computer choice: " + choices[compChoice - 1] + " -- Your choice: " + choices[choice - 1]);
                    System.out.println("Loss\n");
                    lossCount++;
                }
                // Increment to indicate another round is done
                roundCount++;
            }
            
            // Print tie, win, and loss count
            System.out.println("Ties: " + tieCount + ".");
            System.out.println("Wins: " + winCount + ".");
            System.out.println("Losses: " + lossCount + ".\n");
            
            // Ask player if they want to play again, playAgain true if so outer loop loops again
            playAgain = chooseAgain();;
        }
    }
    
    // Returns move choice input from user
    private static int chooseMove() {
        
        // Ask for choice input
        System.out.println();
        System.out.print("Input a choice - 1 for Rock, 2 for Paper, 3 for Scissors: ");
        // Loop until correct input
        do {
            // Catch error in case of non-integer input
            try {
                // Take choice input with scanner
                s = new Scanner(System.in);
                // Int to store player choice
                int choice = s.nextInt();
                // If choice in right range, return choice, otherwise ask again
                if ((choice <= 3) && (choice >=1)) {
                    return choice;
                } 
                else {
                    System.out.println("Your choice must be 1 for Rock, 2 for Paper, 3 for Scissors.");
                }
            } catch(Exception e) {
                System.out.println("Your choice must be an integer.");
            }
        } while(true);
    }
    
    // Returns round count input from user
    private static int chooseRounds() {
        
        // Ask for round count input
        System.out.println();
        System.out.print("Input a round count: ");
        // Catch error in case of non-integer input
        try {
            // Take round count input with scanner
            s = new Scanner(System.in);
            // Input to store round choice
            int rounds = s.nextInt();
            if ((rounds <= 10) && (rounds >= 1)) {
                return rounds;
            } 
            else {
                // Print error and quit if input out of bounds
                System.out.println("The round count must be 1 - 10.");
                System.exit(0);
            }
        } catch(Exception e) {
            System.out.println("The round count must be an integer.");
            System.exit(0);
        }
        
        return 0;
    }
    
    // Returns player input on their choice to play again
    // true if they want to play again, false otherwise
    private static boolean chooseAgain() {
        
        // Loop until correct input
        do {
            try {
                // Ask if player wants to play again, take input
                s = new Scanner(System.in);
                System.out.println("Play again? y/n ");
                String input = s.nextLine();
                // If player inputs 'y', return true to indicate they want to play again
                if (input.equals("y")) {
                    return true;
                } 
                // If player inputs 'n', return false
                else if (input.equals("n")) {
                    System.out.println("Thanks for playing!");
                    return false;
                } 
                // Otherwise, wrong input so ask again
                else {
                    System.out.println("Input either 'y' or 'n', without quotes.");
                }
            } catch(Exception e) {
                System.out.println("Input format error.");
            }
        } while(true);
    }
}
