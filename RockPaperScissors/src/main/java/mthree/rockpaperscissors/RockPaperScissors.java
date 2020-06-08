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

    static int choice = 0;
    static int compChoice;
    static int rounds = 0;
    static int roundCount = 0;
    
    static Scanner s;
    static boolean done;

    public static void main(String[] args) {

        int tieCount;
        int winCount;
        int lossCount;
        
        String[] choices = {"Rock", "Paper", "Scissors"};
        
        String input;
        
        boolean playAgain = true;

        Random r = new Random();
        
        while (playAgain) {
            tieCount = 0;
            winCount = 0;
            lossCount = 0;
            roundCount = 0;
            
            done = false;
            do {
                try {
                    s = new Scanner(System.in);
                    System.out.println("Input a round count: ");
                    rounds = s.nextInt();
                    if ((rounds <= 10) && (rounds >= 1)) {
                        done = true;
                    } else {
                        System.out.println("The round count must be 1 - 10.");
                        System.exit(0);
                    }
                } catch(Exception e) {
                    System.out.println("The round count must be an integer.");
                    System.exit(0);
                }
            } while(!done);
            
            while (roundCount < rounds) {
                Choose();

                compChoice = r.nextInt(3) + 1;
                if (compChoice == choice) {
                    System.out.println("Computer choice: " + choices[compChoice - 1] + " your choice " + choices[choice - 1]);
                    System.out.println("Tie");
                    tieCount++;
                } else if ((choice % 3) == (compChoice + 1) % 3) {
                    System.out.println("Computer choice: " + choices[compChoice - 1] + " your choice " + choices[choice - 1]);
                    System.out.println("Win");
                    winCount++;
                } else {
                    System.out.println("Computer choice: " + choices[compChoice - 1] + " your choice " + choices[choice - 1]);
                    System.out.println("Loss");
                    lossCount++;
                }
                roundCount++;
            }
            
            System.out.println("Ties: " + tieCount + ".");
            System.out.println("Wins: " + winCount + ".");
            System.out.println("Losses: " + lossCount + ".");
            
            done = false;
            do {
                try {
                    s = new Scanner(System.in);
                    System.out.println("Play again? y/n ");
                    input = s.nextLine();
                    if (input.equals("y")) {
                        roundCount = 0;
                        done = true;
                        playAgain = true;
                    } else if (input.equals("n")) {
                        done = true;
                        playAgain = false;
                        System.out.println("Thanks for playing!");
                    } else {
                        System.out.println("Input either 'y' or 'n', without quotes." + input);
                        
                    }
                } catch(Exception e) {
                    System.out.println("Input error.");
                }
            } while(!done);
        }
    }
    
    // 
    private static void Choose() {
        done = false;
        do {
            try {
                s = new Scanner(System.in);
                System.out.println("Input a choice - 1 for Rock, 2 for Paper, 3 for Scissors: ");
                choice = s.nextInt();
                if ((choice <= 3) && (choice >=1)) {
                    done = true;
                } else {
                    System.out.println("Your choice must be 1 for Rock, 2 for Paper, 3 for Scissors.");
                }
            } catch(Exception e) {
                System.out.println("Your choice must be an integer.");
            }
        } while(!done);
    }
}
