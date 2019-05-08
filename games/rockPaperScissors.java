package games;

import java.util.Random;
import java.util.Scanner;   //Here we
//Here we import the utils, scanner and random, used to read data and generate numbers for the computer "AI"

public class rockPaperScissors {

    String playerName; //Here we set up instance variables used throughout the program.
    String playerMove; //These hold the values for player and computer moves. And score.
    String computerMove;
    int score;
    Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args){
        rockPaperScissors rps = new rockPaperScissors();  //Main method calling the method initialise game.
        rps.initialiseGame();
    }


    private void initialiseGame(){
        System.out.println("Enter your name: ");  //Scanner caller reading nextLine for player name.
        playerName = myScanner.nextLine();  //Held in string playername
        playGame();  //Calling method playGame
    }

    private void playGame(){
        System.out.println("Enter your move: ");  //Prompt to enter move, scanner call reading input
        playerMove = myScanner.nextLine();   //Which populates player move variable
        System.out.println(playerName + " has selected " + playerMove + " as their move");
        computerMove = generateComputerMove();
        String result = getWinner(playerMove, computerMove);
        if(result.equalsIgnoreCase("Win")){  //If, else loop handling win conditions and +1 to score.
            System.out.println("Congratulations, you won this round!");
            score++;
        }
        else if(result.equalsIgnoreCase("Lose")){ //If else loop handling lose conditions and -1 to score.
            System.out.println("You lost this round!");
            score--;
        }
        else {
            System.out.println("This round was a draw!"); //Else printing draw message
        }

        if(score < 3 && score > -3){
            playGame();  //If loop reading score variable to determine if a winning or loosing score is achieved.
        }
        else if(score == 3){
            System.out.println("Winner Winner!!"); //Else if score is 3 you've won.
        }
        else if(score == -3){
            System.out.println("You Looooooosssseeeee!"); //Else if score is -3 you lose.
        }

    }

    private String generateComputerMove() {
        Random r = new Random();  //Method calls randomizer to generate number for computer move.
        String move = "";
        int i = r.nextInt(3); //populating local variable i to hold computer move number.
        switch(i){
            case 0:
                move = "Rock";  //Based on 0-3 cases handle rock, paper scissors for computer move.
                break;

            case 1:
                move = "Paper";
                break;

            case 2:
                move = "Scissors";
                break;
        }
        return move;
    }

    private String getWinner(String playerMove, String computerMove){
        String outcome = "";
        if(playerMove.equalsIgnoreCase("rock")){   //Method handles all possible combinations for the game.
            if(computerMove.equalsIgnoreCase("rock")){ //Uses if else loops to generate win/lose draw outcome.
                outcome = "Draw";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Lose";
            }
            else{
                outcome = "Win";
            }
        }
        if(playerMove.equalsIgnoreCase("paper")){ //If else loop continues to calculate combinations
            if(computerMove.equalsIgnoreCase("rock")){  //Ie. Rock beats paper
                outcome = "Win";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Draw";
            }
            else{
                outcome = "Lose";
            }
        }
        if(playerMove.equalsIgnoreCase("scissors")){   //If else loop continues to work on game combinations.
            if(computerMove.equalsIgnoreCase("rock")){ //Ie. Rock beats scissors
                outcome = "Lose";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Win";
            }
            else{
                outcome = "Draw";
            }
        }
        return outcome;
    }
}
